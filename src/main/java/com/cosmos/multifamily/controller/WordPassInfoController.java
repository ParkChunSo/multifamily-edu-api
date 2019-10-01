package com.cosmos.multifamily.controller;

import com.cosmos.multifamily.dto.WordInfoResponseDto;
import com.cosmos.multifamily.service.WordPassInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by YoungMan on 2019-01-01.
 */

@RestController
public class WordPassInfoController {
    private Logger logger = LoggerFactory.getLogger(WordPassInfoController.class);
    private final WordPassInfoService wordPassInfoService;

    public WordPassInfoController(WordPassInfoService wordPassInfoService) {
        this.wordPassInfoService = wordPassInfoService;
    }

    @GetMapping("/wordinfo/level/{level}/userid/{userid}")
    public WordInfoResponseDto getWordPassInfoDtoBySelectLevelAndUserid(@PathVariable("level") String level,
                                                                        @PathVariable("userid") String userid) {
        return wordPassInfoService.getBySelectLevelAndUserId(level, userid);
    }

    @GetMapping("/wordinfo/userid/{userid}/wordname/{wordname}")
    public Map<String, String> setWordPassInfo(@PathVariable("userid") String userId,
                                               @PathVariable("wordname") String wordName) {
        return wordPassInfoService.setWordPassInfo(userId, wordName);
    }

}
