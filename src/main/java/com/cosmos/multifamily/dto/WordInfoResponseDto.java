package com.cosmos.multifamily.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YoungMan on 2019-01-01.
 */

@Getter
public class WordInfoResponseDto {
    private List<String> wordList;
    private Map<String, String> wordPassInfo = new HashMap<>();

    @Builder
    public WordInfoResponseDto(List<String> wordList, Map<String, String> wordPassInfo) {
        this.wordList = wordList;
        this.wordPassInfo = wordPassInfo;
    }
}
