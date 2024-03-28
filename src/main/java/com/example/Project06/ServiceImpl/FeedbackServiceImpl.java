package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.FeedbackDto;
import com.example.Project06.Entity.Feedback;
import com.example.Project06.Entity.User;
import com.example.Project06.Repository.FeedbackRepo;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.FeedbackService;
import com.example.Project06.exception.FeedbackNotFoundByIdException;
import com.example.Project06.exception.FeedbackNotFoundException;
import com.example.Project06.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FeedbackServiceImpl implements FeedbackService{

    @Autowired
    private FeedbackRepo feedbackRepo;

    @Autowired
    private UserRepository userRepository;

    @Override
    public FeedbackDto addFeedback(FeedbackDto feedbackDto, Integer user_id) {
        Feedback feedback=dtoToFeedback(feedbackDto,user_id);
        Feedback savedFeedback=feedbackRepo.save(feedback);
        FeedbackDto feedbackDto1=feedbackToDto(savedFeedback);
        return feedbackDto;
    }

    @Override
    public Feedback updateFeedback(FeedbackDto feedbackDto, Integer feedbackId) {
        try {
            Feedback feedback = feedbackRepo.findById(feedbackId).orElse(null);
            if (feedback != null) {

                feedback.setDate(feedbackDto.getDate());
                feedback.setFeedback(feedbackDto.getFeedback());
                return feedbackRepo.save(feedback);
            }
        } catch (Exception e) {
            throw new FeedbackNotFoundByIdException("Feedback Not Found" + feedbackId);
        }
              return null;
    }


    @Override
    public FeedbackDto getFeedbackById(Integer feedbackId) {
        Optional<Feedback>byId=this.feedbackRepo.findById(feedbackId);
        if (byId.isPresent()){
            Feedback feedback=byId.get();
            FeedbackDto feedbackDto=new FeedbackDto();
            return this.feedbackToDto(feedback);
        }else{
            throw new FeedbackNotFoundByIdException("Feedback Not Found");
        }
    }

    @Override
    public List<FeedbackDto> getAllFeedback() {
        List<Feedback> feedbackList = feedbackRepo.findAll();
        return feedbackList.stream()
                .map(this::feedbackToDto)
                .collect(Collectors.toList());
    }

  /*  @Override
  public List<Feedback> getAllFeedback() {


        return feedbackRepo.findAll();
    }*/

    @Override
    public String deleteFeedback(Integer feedbackId) {
        Optional<Feedback>byId=this.feedbackRepo.findById(feedbackId);
        if(byId.isPresent()){
            feedbackRepo.deleteById(feedbackId);
            return "Feedback Deleted Successfully";
        }else{
            throw new FeedbackNotFoundByIdException("Feedback Not Found");
        }
    }


    private Feedback dtoToFeedback(FeedbackDto feedbackDto,Integer userId)
    {
        Feedback feedback=new Feedback();

        feedback.setFeedbackId(feedbackDto.getFeedbackId());
        feedback.setFeedback(feedbackDto.getFeedback());
        feedback.setDate(feedbackDto.getDate());
        User user=userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        feedback.setUserUser(user);

        return feedback;
    }

    private FeedbackDto feedbackToDto(Feedback feedback)
    {
        FeedbackDto feedbackDto=new FeedbackDto();

        feedbackDto.setFeedbackId(feedback.getFeedbackId());
        feedbackDto.setFeedback(feedback.getFeedback());
        feedbackDto.setDate(feedback.getDate());
        feedbackDto.setUserId(feedback.getUserUser().getUser_id());

        return feedbackDto;

    }

}

