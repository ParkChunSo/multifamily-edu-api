package com.cosmos.multifamily.repository;

import com.cosmos.multifamily.domain.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by YoungMan on 2019-01-01.
 */

public interface WordRepository extends JpaRepository<Word, String> {

    @Query(value = "select word.name from Word word where word.level = :selectLevel")
    List<String> getWordsByLevel(@Param("selectLevel") String selectLevel);

    Word findWordByName(String name);
}
