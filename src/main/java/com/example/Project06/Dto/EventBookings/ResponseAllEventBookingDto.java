package com.example.Project06.Dto.EventBookings;


import lombok.Data;

import java.util.List;

@Data
public class ResponseAllEventBookingDto {

    private String status;
    private List<EventBookingDto> response;


    public ResponseAllEventBookingDto(String status) {

        this.status = status;
    }


}
