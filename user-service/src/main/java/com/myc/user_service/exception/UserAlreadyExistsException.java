package com.myc.user_service.exception;

public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(){
        super("User Already Exists");
    }
}
