package com.fashion.fashionblogapi.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NumberFormatException extends RuntimeException{

    private String debugMessage;
    public NumberFormatException(String message){
        super(message);
    }

    public NumberFormatException(String message, String debugMessage) {
        super(message);
        this.debugMessage = debugMessage;
    }
}
