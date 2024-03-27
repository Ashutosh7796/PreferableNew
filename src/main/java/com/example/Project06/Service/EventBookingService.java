package com.example.Project06.Service;

import com.example.Project06.Dto.EventBookings.EventBookingDto;

import java.time.OffsetDateTime;
import java.util.List;

public interface EventBookingService {

    void save(EventBookingDto eventBookingDto);

    List<EventBookingDto> getAllEventBooking();

    EventBookingDto getById(Integer eventid);

    String updateEventBookingDetails(OffsetDateTime date, String status, Integer eventeventid);

    String deleteById(Integer eventeventid);

}
