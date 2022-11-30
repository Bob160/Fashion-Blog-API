package com.fashion.fashionblogapi.exceptions;

public class UserNotFoundException extends RuntimeException{


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

}
