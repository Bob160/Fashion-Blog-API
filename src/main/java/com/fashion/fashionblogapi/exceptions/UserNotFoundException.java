package com.fashion.fashionblogapi.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundException extends RuntimeException{


    private String DebugMessage;
    //Create No Args Constructor
//    UserNotFoundException() {
//        super();
//
//    }
//
//    // All Args Constructor
//    UserNotFoundException(String msg) {
//        super(msg);
//        this.message = msg;
//    }


    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, String debugMessage) {
        super(message);
        DebugMessage = debugMessage;
    }
}
