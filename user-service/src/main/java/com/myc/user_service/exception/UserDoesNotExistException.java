package com.myc.user_service.exception;

public class UserDoesNotExistException extends Exception{
    public UserDoesNotExistException(){
        super("User Does not Exist");
    }
}
