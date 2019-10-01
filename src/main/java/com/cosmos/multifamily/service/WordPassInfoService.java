package com.cosmos.multifamily.service;

import com.cosmos.multifamily.dto.WordInfoResponseDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by YoungMan on 2018-12-19.
 */

@Transactional
public interface WordPassInfoService {

    WordInfoResponseDto getBySelectLevelAndUserId(String selectLevel, String userId);

    Map<String, String> setWordPassInfo(String userId, String wordName);
}
