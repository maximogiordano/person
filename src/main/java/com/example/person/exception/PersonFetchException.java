package com.example.person.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PersonFetchException extends RuntimeException {
    public PersonFetchException(Exception e) {
        super(e);
    }
}
