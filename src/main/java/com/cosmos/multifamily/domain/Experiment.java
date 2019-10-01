package com.cosmos.multifamily.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Created by YoungMan on 2018-12-19.
 */

@Entity
@Getter
public class Experiment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotEmpty
    private String user;

    @Column(nullable = false)
    @NotEmpty
    private String word;

    @Column(name = "area_score", nullable = false)
    @NotEmpty
    private int areaScore;

    @Column(name = "shape_score", nullable = false)
    @NotEmpty
    private int shapeScore;

    public Experiment() {
    }

    @Builder
    public Experiment(String user, String word, int areaScore, int shapeScore) {
        this.user = user;
        this.word = word;
        this.areaScore = areaScore;
        this.shapeScore = shapeScore;
    }
}
