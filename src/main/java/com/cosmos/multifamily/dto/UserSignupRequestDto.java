package com.cosmos.multifamily.dto;

import com.cosmos.multifamily.domain.User;
import lombok.Getter;

/**
 * Created by YoungMan on 2018-12-19.
 */

@Getter
public class UserSignupRequestDto {

    private String userId;
    private String userPw;
    private String name;
    private String mobile;

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .userPw(userPw)
                .name(name)
                .mobile(mobile)
                .build();
    }
}
