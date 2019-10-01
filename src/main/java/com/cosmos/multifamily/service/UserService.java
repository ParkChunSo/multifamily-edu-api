package com.cosmos.multifamily.service;

import com.cosmos.multifamily.dto.SignInDto;
import com.cosmos.multifamily.dto.UserSignupRequestDto;
import com.cosmos.multifamily.domain.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YoungMan on 2018-12-19.
 */

@Transactional
public interface UserService {

    void signUpUser(UserSignupRequestDto userSignupRequestDto);

    User findUserByUserId(String userId);

    void convertToNextDay(String userId, String level);

    void signInUser(SignInDto dto);
}
