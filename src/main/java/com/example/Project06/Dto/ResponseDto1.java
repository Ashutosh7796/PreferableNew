package com.example.Project06.Dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto1 {

    public String status;
    public String messege;

    public ResponseDto1(String status,String messege){

        this.status=status;
        this.messege=messege;
    }
    public ResponseDto1(){

    }

}
