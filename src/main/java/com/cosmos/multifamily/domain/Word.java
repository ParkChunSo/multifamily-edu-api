package com.cosmos.multifamily.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-01-01.
 */

@Entity
@Getter @NoArgsConstructor
public class Word {
    @Id
    @Column(name = "name")
    private String name;

    @Column(nullable = false)
    private String level;

    @OneToMany(mappedBy = "word")
    private List<WordPassInfo> wordPassInfo = new ArrayList<>();

    @Builder
    public Word(String name, String level, List<WordPassInfo> wordPassInfo) {
        this.name = name;
        this.level = level;
        this.wordPassInfo = wordPassInfo;
    }
}
