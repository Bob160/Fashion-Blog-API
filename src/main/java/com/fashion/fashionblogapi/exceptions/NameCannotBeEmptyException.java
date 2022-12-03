package com.fashion.fashionblogapi.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NameCannotBeEmptyException extends RuntimeException{

    private String debugMessage;

    public NameCannotBeEmptyException(String message){
        super(message);
    }

    public NameCannotBeEmptyException(String message, String debugMessage) {
        super(message);
        this.debugMessage = debugMessage;
    }
}
