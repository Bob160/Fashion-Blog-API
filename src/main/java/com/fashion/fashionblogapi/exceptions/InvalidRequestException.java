package com.fashion.fashionblogapi.exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidRequestException extends RuntimeException{

    private String debugMessage;

    public InvalidRequestException(String message) {
        super(message);
        this.debugMessage = debugMessage;
    }
}
