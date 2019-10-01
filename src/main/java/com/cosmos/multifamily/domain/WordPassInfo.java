package com.cosmos.multifamily.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

/**
 * Created by YoungMan on 2019-01-01.
 */

@Entity
@Getter
public class WordPassInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "word_name")
    private Word word;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public WordPassInfo() {
    }

    @Builder
    public WordPassInfo(Word word, User user) {
        this.word = word;
        this.user = user;
    }
}
