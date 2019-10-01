package com.cosmos.multifamily.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2018-12-19.
 */

@Entity
@Getter @Setter
public class User {

    @Id
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String userPw;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = false)
    private String level = "1";

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<WordPassInfo> wordPassInfo = new ArrayList<>();

    @Transient
    private String response;

    public User() {
    }

    @Builder
    public User(String userId, String userPw, String name, String mobile) {
        this.userId = userId;
        this.userPw = userPw;
        this.name = name;
        this.mobile = mobile;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
}
