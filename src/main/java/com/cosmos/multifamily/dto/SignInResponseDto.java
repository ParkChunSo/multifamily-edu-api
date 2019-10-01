package com.cosmos.multifamily.dto;

import com.cosmos.multifamily.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignInResponseDto {
    private String id;
    private String pw;
    private String name;
    private String mobile;
    private String level;
    private String count;
    private String response;

    @Builder
    public SignInResponseDto(String id, String pw, String name, String mobile, String level, String count, String response) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.mobile = mobile;
        this.level = level;
        this.count = count;
        this.response = response;
    }

    public SignInResponseDto newInstance(User user){
        return SignInResponseDto.builder()
                .id(user.getUserId())
                .pw(user.getUserPw())
                .count("100")
                .name(user.getName())
                .build();
    }
}
