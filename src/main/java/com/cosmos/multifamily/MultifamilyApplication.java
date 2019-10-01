package com.cosmos.multifamily;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * Created by YoungMan on 2018-12-19.
 */

@SpringBootApplication
@EnableJpaAuditing
public class MultifamilyApplication {

    @PostConstruct
    public void initApplication(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    public static void main(String[] args) {
        SpringApplication.run(MultifamilyApplication.class, args);
    }
}
