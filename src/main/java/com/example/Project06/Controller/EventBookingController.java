package com.example.Project06.Controller;

import com.example.Project06.Dto.EventBookings.EventBookingDto;
import com.example.Project06.Dto.EventBookings.ResponseAllEventBookingDto;
import com.example.Project06.Dto.EventBookings.ResponseEventBookingDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Service.EventBookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;


@RestController
@AllArgsConstructor
@RequestMapping("/eventbookings")

public class EventBookingController {
    private final EventBookingService eventBookingService;


    @PostMapping("/add")
    public ResponseEntity<?> saveEventBookingDetails(@RequestBody EventBookingDto eventBookingDto) {
        try {
            eventBookingService.save(eventBookingDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", "Event booking details added"));
        } catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("unsuccess", "Event id details  not found "));
        }
    }


    @GetMapping("/all")

    public ResponseEntity<?> getAll() {
        try {
            ResponseAllEventBookingDto responseObjectDto = new ResponseAllEventBookingDto("success");
            responseObjectDto.setResponse(eventBookingService.getAllEventBooking());
            return ResponseEntity.status(HttpStatus.OK).body(responseObjectDto);
        }catch (RuntimeException e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }


    @GetMapping("/id")  //rum as postman param key and value
    public ResponseEntity<?> getById(Integer eventid)
    {
        try {
            ResponseEventBookingDto responseSingleDto = new ResponseEventBookingDto("success");
            responseSingleDto.setResponse(eventBookingService.getById(eventid));
            return ResponseEntity.status(HttpStatus.OK).body(responseSingleDto);
        }catch (RuntimeException e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateById(

            @RequestParam OffsetDateTime date,

            @RequestParam String status,

            @RequestParam Integer eventeventid

    ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",eventBookingService.updateEventBookingDetails(
                    date,status,eventeventid

            )));
        }catch (RuntimeException e)
        {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteById( @RequestParam Integer eventeventid) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",eventBookingService.deleteById(eventeventid)));
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }



}
