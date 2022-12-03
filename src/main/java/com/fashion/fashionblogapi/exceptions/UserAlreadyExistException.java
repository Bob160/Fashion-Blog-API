package com.fashion.fashionblogapi.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAlreadyExistException extends RuntimeException{
    private String debugMessage;

    public UserAlreadyExistException(String message){
        super(message);
    }

    public UserAlreadyExistException(String message, String debugMessage) {
        super(message);
        this.debugMessage = debugMessage;
    }
}
