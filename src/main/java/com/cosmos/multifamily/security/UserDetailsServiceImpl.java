package com.cosmos.multifamily.security;

import com.cosmos.multifamily.domain.User;
import com.cosmos.multifamily.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YoungMan on 2019-01-01.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public org.springframework.security.core.userdetails.User loadUserByUsername(String userId) throws UsernameNotFoundException {
        User newUser = userRepository.findUserByUserId(userId);
        if (newUser == null) {
            throw new UsernameNotFoundException(userId);
        }

        return new org.springframework.security.core.userdetails.User(newUser.getUserId(), newUser.getUserPw(), makeGrantedAuthority(Stream.of("USER").collect(Collectors.toList())));
    }

    private List<GrantedAuthority> makeGrantedAuthority(List<String> roles) {
        return roles.stream()
                .map(memberRole -> new SimpleGrantedAuthority("ROLE_" + memberRole))
                .collect(Collectors.toList());
    }
}
