package com.cosmos.multifamily.exception;

import lombok.Getter;

/**
 * Created by YoungMan on 2019-01-01.
 */

@Getter
public class UserDefineException extends RuntimeException {

    public UserDefineException(String message) {
        super(message);
    }

}
