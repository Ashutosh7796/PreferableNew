package com.example.Project06.Dto.EventBookings;


import lombok.Data;

@Data
public class ResponseEventBookingDto {

    private String status;
    private EventBookingDto response;

    public ResponseEventBookingDto(String status) {

        this.status = status;
    }
}
