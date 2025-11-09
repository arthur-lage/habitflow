package com.arthurlage.habitflow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UsernameOrEmailTakenException extends RuntimeException {
    public UsernameOrEmailTakenException(String message) {
        super(message);
    }
}
