package com.example.wavelink.Business.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserExistsException extends ResponseStatusException {

    public UserExistsException(){
        super (HttpStatus.BAD_REQUEST, "Username_exists");
    }
}
