package com.cosmos.multifamily.service.impl;

import com.cosmos.multifamily.dto.WordInfoResponseDto;
import com.cosmos.multifamily.domain.User;
import com.cosmos.multifamily.domain.Word;
import com.cosmos.multifamily.domain.WordPassInfo;
import com.cosmos.multifamily.exception.UserDefineException;
import com.cosmos.multifamily.repository.UserRepository;
import com.cosmos.multifamily.repository.WordPassInfoRepository;
import com.cosmos.multifamily.repository.WordRepository;
import com.cosmos.multifamily.service.WordPassInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YoungMan on 2018-12-19.
 */

@Service
public class WordPassInfoServiceImpl implements WordPassInfoService {
    private Logger logger = LoggerFactory.getLogger(WordPassInfoServiceImpl.class);
    private final WordPassInfoRepository wordPassInfoRepository;
    private final WordRepository wordRepository;
    private final UserRepository userRepository;

    public WordPassInfoServiceImpl(WordPassInfoRepository wordPassInfoRepository, WordRepository wordRepository, UserRepository userRepository) {
        this.wordPassInfoRepository = wordPassInfoRepository;
        this.wordRepository = wordRepository;
        this.userRepository = userRepository;
    }

    @Override
    public WordInfoResponseDto getBySelectLevelAndUserId(String selectLevel, String userId) {
        List<String> words = new ArrayList<>();
        List<String> wordsPass = new ArrayList<>();
        Map<String, String> wordsPassInfo = new HashMap<>();

        try {
            words = wordRepository.getWordsByLevel(selectLevel);
            wordsPass = wordPassInfoRepository.getBySelectLevelAndUserId(selectLevel, userId);
            wordsPassInfo = convertWordsToWordsPassInfo(words, wordsPass);
        } catch (Exception e) {
            throw new UserDefineException(e.getMessage());
        }
        return new WordInfoResponseDto(words, wordsPassInfo);
    }

    private Map<String, String> convertWordsToWordsPassInfo(List<String> words, List<String> wordsPass) {
        Map<String, String> wordPassInfo = new HashMap<>();

        for (String word : words) {
            if (wordsPass.contains(word)) {
                wordPassInfo.put(word, "합격");
            } else {
                wordPassInfo.put(word, "불합격");
            }
        }
        return wordPassInfo;
    }

    @Override
    public Map<String, String> setWordPassInfo(String userId, String wordName) {
        Map<String, String> map = new HashMap<>();

        try {
            Word word = wordRepository.findWordByName(wordName);
            User user = userRepository.findUserByUserId(userId);

            if (word != null) {
                WordPassInfo wordPassInfo = WordPassInfo.builder()
                        .word(word)
                        .user(user)
                        .build();
                wordPassInfoRepository.save(wordPassInfo);
                map.put(wordName, "합격");
            } else {
                throw new UserDefineException("Word Null Error");
            }
        } catch (Exception e) {
            throw new UserDefineException(e.getMessage());
        }
        return map;
    }
}
