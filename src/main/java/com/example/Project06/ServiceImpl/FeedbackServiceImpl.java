package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.FeedbackDto;
import com.example.Project06.Entity.Feedback;
import com.example.Project06.Entity.User;
import com.example.Project06.Repository.FeedbackRepo;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.FeedbackService;
import com.example.Project06.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service

public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepo feedbackRepo;

    @Autowired
    private UserRepository userRepository;

    @Override
    public FeedbackDto addFeedback(FeedbackDto feedbackDto ,Integer userId) {
        Feedback feedback = dtoToFeedback(feedbackDto, userId);
        Feedback savedFeedback = feedbackRepo.save(feedback);
        FeedbackDto feedbackDto1 = feedbackToDto(savedFeedback);
        return feedbackDto1;
    }

    @Override
    public Feedback updatePost(FeedbackDto feedbackDto, Integer feedbackId) {
        return null;
    }

    @Override
    public FeedbackDto getFeedbackById(Integer feedbackId) {
        return null;
    }

    @Override
    public List<FeedbackDto> getAllFeedback() {
        return null;
    }

    @Override
    public void deletePost(Integer feedbackId) {

    }

    private Feedback dtoToFeedback(FeedbackDto feedbackDto,Integer userId)
    {
        Feedback feedback = new Feedback();
        feedback.setFeedbackId(feedbackDto.getFeedbackId());
        feedback.setFeedback(feedbackDto.getFeedback());
        feedback.setDate(feedbackDto.getDate());
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        feedback.setUserUser(user);

        return feedback;
    }

    private FeedbackDto feedbackToDto(Feedback feedback)
    {
        FeedbackDto feedbackDto = new FeedbackDto();
        feedbackDto.setFeedbackId(feedback.getFeedbackId());
        feedbackDto.setFeedback(feedback.getFeedback());
        feedbackDto.setDate(feedback.getDate());
        feedbackDto.setUserId(feedback.getUserUser().getUser_id());
        return feedbackDto;
    }
}
