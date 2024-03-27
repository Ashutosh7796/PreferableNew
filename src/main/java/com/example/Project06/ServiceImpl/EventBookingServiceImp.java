package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.EventBookings.EventBookingDto;
import com.example.Project06.Entity.EventBooking;
import com.example.Project06.Entity.Events;
import com.example.Project06.Repository.EventBookingRepository;
import com.example.Project06.Repository.EventsRepo;
import com.example.Project06.Service.EventBookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class EventBookingServiceImp implements EventBookingService {



    private final EventBookingRepository eventBookingRepository;

    private  final EventsRepo eventsRepo;

    @Override

    public void save (EventBookingDto eventBookingDto)
    {


        Events events = eventsRepo.getById(eventBookingDto.getEventId());

        EventBooking eventBooking = new EventBooking(eventBookingDto);

        eventBooking.setEventsEventsid(events);

        eventBookingRepository.save(eventBooking);


    }

    @Override
    public List<EventBookingDto> getAllEventBooking() {

        return eventBookingRepository.findAll().stream().map(EventBookingDto::new).collect(Collectors.toList());
    }

    @Override
    public EventBookingDto getById(Integer eventid) {

        return eventBookingRepository.findById(eventid).map(EventBookingDto::new).orElseThrow(()->new RuntimeException("events bookings not found by id"));
    }

    @Override
    public String updateEventBookingDetails(OffsetDateTime date, String status, Integer eventeventid) {

        EventBooking eventBooking = eventBookingRepository.findById(eventeventid).orElseThrow(() -> new RuntimeException("events booking details Not found By Id"));

        eventBooking.setDate((String.valueOf(date)).length()>0 ? date : eventBooking.getDate());
        eventBooking.setStatus(status.length()>0 ? status : eventBooking.getStatus());
        eventBookingRepository.save(eventBooking);
        return "events booking details updated";

    }




    @Override
    public String deleteById(Integer eventeventid) {
        EventBooking eventBooking = eventBookingRepository.findById(eventeventid).orElseThrow(() -> new RuntimeException(" events booking details Not found By Id"));
        eventBookingRepository.deleteById(eventeventid);
        return "events booking details deleted";
    }



}
