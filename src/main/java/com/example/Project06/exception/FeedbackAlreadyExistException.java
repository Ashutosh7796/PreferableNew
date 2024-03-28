package com.example.Project06.exception;

public class FeedbackAlreadyExistException  extends RuntimeException{
    public FeedbackAlreadyExistException(String messege){
        super(messege);
    }

    public FeedbackAlreadyExistException(String s,String messege){

    }
}
