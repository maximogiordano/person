package com.example.person.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PersonNameAlreadyExistsException extends RuntimeException {
    public PersonNameAlreadyExistsException() {
        super("Another person with the given name already exists.");
    }
}
