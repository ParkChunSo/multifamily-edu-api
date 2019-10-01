package com.cosmos.multifamily.dto;

import com.cosmos.multifamily.domain.Experiment;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

/**
 * Created by YoungMan on 2018-12-19.
 */

@Getter
public class ExperimentRequestDto {
    @NotEmpty
    private String user;

    @NotEmpty
    private String word;

    @NotEmpty
    private int areaScore;

    @NotEmpty
    private int shapeScore;

    public Experiment toEntity() {
        return Experiment.builder()
                .user(user)
                .word(word)
                .areaScore(areaScore)
                .shapeScore(shapeScore)
                .build();
    }
}
