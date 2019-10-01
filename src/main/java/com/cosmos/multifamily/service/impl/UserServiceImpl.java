package com.cosmos.multifamily.service.impl;

import com.cosmos.multifamily.dto.SignInDto;
import com.cosmos.multifamily.dto.UserSignupRequestDto;
import com.cosmos.multifamily.domain.User;
import com.cosmos.multifamily.exception.UserDefineException;
import com.cosmos.multifamily.repository.UserRepository;
import com.cosmos.multifamily.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * Created by YoungMan on 2018-12-19.
 */

@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signUpUser(UserSignupRequestDto userSignupRequestDto) {
        try {
            User existingUser = userRepository.findUserByUserId(userSignupRequestDto.getUserId());
            if (existingUser == null) {
                User user = userSignupRequestDto.toEntity();
                user.setUserPw(passwordEncoder.encode(user.getUserPw()));
                userRepository.save(user);
            } else {
                throw new UserDefineException("Error");
            }
        } catch (Exception e) {
            throw new UserDefineException("Error");
        }
    }

    @Override
    public User findUserByUserId(String userId) {
        User user;

        try {
            user = userRepository.findUserByUserId(userId);
        } catch (Exception e) {
            throw new UserDefineException("Error");
        }
        return user;
    }

    @Override
    public void convertToNextDay(String userId, String level) {
        User user = userRepository.findUserByUserId(userId);
        user.setLevel(level);
        userRepository.save(user);
    }

    @Override
    public void signInUser(SignInDto dto) {
        User user = userRepository.findUserByUserId(dto.getUserId());
        if(ObjectUtils.isEmpty(user))
            throw new UserDefineException("아이디를 잘못 입력하셨습니다.");

        if(!user.getUserPw().equals(dto.getUserPw()))
            throw new UserDefineException("비밀번호를 잘못 입력하셨습니다.");
    }
}
