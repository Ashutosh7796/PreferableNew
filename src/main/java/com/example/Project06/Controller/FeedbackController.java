package com.example.Project06.Controller;

import com.example.Project06.Dto.FeedbackDto;
import com.example.Project06.Dto.ResponceDto;
import com.example.Project06.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")

public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/add")
    public ResponseEntity<FeedbackDto> addFeedback(@RequestBody FeedbackDto feedbackDto , Integer userId){
        FeedbackDto addedFeedback = this.feedbackService.addFeedback(feedbackDto ,userId );
        return new ResponseEntity<FeedbackDto>(addedFeedback, HttpStatus.OK);
    }
}
