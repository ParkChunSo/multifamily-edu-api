package com.cosmos.multifamily.repository;

import com.cosmos.multifamily.domain.WordPassInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by YoungMan on 2019-01-01.
 */

public interface WordPassInfoRepository extends JpaRepository<WordPassInfo, Long> {

    @Query("select word.name " +
            "from WordPassInfo wordPassInfo " +
            "join wordPassInfo.word word " +
            "join wordPassInfo.user user " +
            "where word.level = :selectLevel " +
            "and user.userId = :userId")
    List<String> getBySelectLevelAndUserId(@Param("selectLevel") String selectLevel, @Param("userId") String userId);

    /*@Query(value = "select word.name from WordPassInfo wordPassInfo, Word word where wordPassInfo.word = word.name")
    List<String> getBySelectLevelAndUserId(@Param("selectLevel") String selectLevel, @Param("userId") String userId);*/
}
