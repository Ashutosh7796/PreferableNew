package com.example.Project06.Service;


import com.example.Project06.Dto.FeedbackDto;
import com.example.Project06.Entity.Feedback;

import java.util.List;

public interface FeedbackService {

    public FeedbackDto addFeedback(FeedbackDto feedbackDto,Integer user_id);

    public Feedback updateFeedback(FeedbackDto feedbackDto,Integer feedbackId);

    public FeedbackDto getFeedbackById(Integer feedbackId);

     List<FeedbackDto> getAllFeedback();

    public String deleteFeedback(Integer feedbackId);



}