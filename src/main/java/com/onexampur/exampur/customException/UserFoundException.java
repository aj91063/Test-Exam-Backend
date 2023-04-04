package com.onexampur.exampur.customException;




public class UserFoundException extends Exception {
    public UserFoundException() {
        super("User already exist !!");
    }

    public UserFoundException(String message) {
        super(message);
    }
}