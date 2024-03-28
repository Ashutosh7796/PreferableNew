package com.example.Project06.Controller;

import com.example.Project06.Dto.FeedbackDto;

import com.example.Project06.Entity.Feedback;
import com.example.Project06.Service.FeedbackService;
import com.example.Project06.exception.FeedbackNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/feedback")

public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/add/{userId}")
    public ResponseEntity<FeedbackDto>addFeedback(@RequestBody FeedbackDto feedbackDto,@PathVariable Integer userId){
        FeedbackDto addedFeedback=this.feedbackService.addFeedback(feedbackDto,userId);
        return new ResponseEntity<FeedbackDto>(addedFeedback,HttpStatus.OK);

    }


    @GetMapping("/all")
    public List<FeedbackDto>getAllFeedback(){

        return feedbackService.getAllFeedback();
    }

    @GetMapping("/get/{feedbackId}")
    public ResponseEntity<Optional<Object>>showFeedback(@PathVariable("feedbackId")Integer feedbackId) {
        try {
            Optional<Object> feedbackById = Optional.ofNullable(this.feedbackService.getFeedbackById(feedbackId));
            if (feedbackById.isPresent()) {
                return ResponseEntity.ok(feedbackById);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Optional.empty());
        }

    }

   @PutMapping("/update/{feedbackId}")
   public ResponseEntity<String> updateFeedback(@RequestBody FeedbackDto feedbackDto, @PathVariable("feedbackId") Integer feedbackId) {
       try {
           this.feedbackService.updateFeedback(feedbackDto, feedbackId);
           return ResponseEntity.ok("Feedback updated successfully");
       } catch (FeedbackNotFoundException e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Feedback not found for ID: " + feedbackId);
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update feedback: " + e.getMessage());
       }
   }


    @DeleteMapping("/delete/{feedbackId}")
    public ResponseEntity<String>deleteFeedback(@PathVariable("feedbackId") Integer feedbackId){
        try{
            this.feedbackService.deleteFeedback(feedbackId);
            return ResponseEntity.ok("Feedback Deleted Successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail To Delete:"+e.getMessage());
        }
    }

}
