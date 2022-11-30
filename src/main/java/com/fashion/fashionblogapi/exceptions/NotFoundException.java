package com.fashion.fashionblogapi.exceptions;

public class NotFoundException extends RuntimeException{

    private String message;

    //Create No Args Constructor
    NotFoundException() {
        super();

    }

    // All Args Constructor
    NotFoundException(String msg) {
        super(msg);
        this.message = msg;
    }


}
