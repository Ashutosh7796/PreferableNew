package com.example.Project06.Dto.EventBookings;

import com.example.Project06.Entity.EventBooking;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class EventBookingDto {

    private OffsetDateTime date;

    private Integer userId;

    private String status;

    private Integer eventId;


    public EventBookingDto(EventBooking eventBooking) {
        this.date = eventBooking.getDate();
        this.userId = eventBooking.getUserId();
        this.status = eventBooking.getStatus();
        this.eventId =eventBooking.getEventsEventsid().getEventsid();
    }
}
