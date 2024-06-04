package com.example.wavelink.Business.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpRequest;

public class UserNotFoundException extends ResponseStatusException {

    public UserNotFoundException(String error) {
        super(HttpStatus.BAD_REQUEST, error);
    }
}
