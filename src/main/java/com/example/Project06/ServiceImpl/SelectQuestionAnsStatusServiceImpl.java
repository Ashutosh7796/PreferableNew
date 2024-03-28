package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.SelectQuestionAnsStatusDto;
import com.example.Project06.Entity.SelectQuestionAnsStatus;
import com.example.Project06.Repository.SelectQuestionAnsStatusRepo;
import com.example.Project06.Service.SelectQuestionAnsStatusService;
import com.example.Project06.exception.ExamAnsnotFoundByIdException;
import com.example.Project06.exception.SelectQuestionAnsStatusNotFoundByIdException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SelectQuestionAnsStatusServiceImpl  implements SelectQuestionAnsStatusService {


    private final SelectQuestionAnsStatusRepo selectQuestionAnsStatusRepo;



    @Override
    public String addSelectQuestionAnsStatus(SelectQuestionAnsStatusDto selectQuestionAnsStatusDto) {

        SelectQuestionAnsStatus selectQuestionAnsStatus = new SelectQuestionAnsStatus(selectQuestionAnsStatusDto);

        selectQuestionAnsStatusRepo.save(selectQuestionAnsStatus);

        return "SelectQuestionAnsStatus Added";
    }


    @Override
    public List<SelectQuestionAnsStatus> getAllSelectQuestionAnsStatus() {
        return selectQuestionAnsStatusRepo.findAll();
    }

    @Override
    public SelectQuestionAnsStatusDto getSelectQuestionAnsStatusById(Integer selectQuestionAnsStatusById) {
        Optional<SelectQuestionAnsStatus> byId = this.selectQuestionAnsStatusRepo.findById(selectQuestionAnsStatusById);
        if (byId.isPresent()) {
            SelectQuestionAnsStatus selectQuestionAnsStatus = byId.get();
            SelectQuestionAnsStatusDto selectQuestionAnsStatusDto = new SelectQuestionAnsStatusDto();
            return new SelectQuestionAnsStatusDto(selectQuestionAnsStatus);
        } else {
            throw new SelectQuestionAnsStatusNotFoundByIdException("SelectQuestionAns Not Found");
        }
    }

    @Override
    public String deleteSelectQuestionAnsStatus(Integer selectedQuestionId) {
        Optional<SelectQuestionAnsStatus> byId = this.selectQuestionAnsStatusRepo.findById(selectedQuestionId);
        if (byId.isPresent()) {
            selectQuestionAnsStatusRepo.deleteById(selectedQuestionId);
            return "Deleted Sucessfully";
        } else {
            throw new ExamAnsnotFoundByIdException("Not Found");
        }
    }

    @Override
    public SelectQuestionAnsStatus updateSelectQuestionAnsStatus(SelectQuestionAnsStatusDto selectQuestionAnsStatusDto, Integer selectedQuestionId) {
        try {
            SelectQuestionAnsStatus selectQuestionAnsStatus = selectQuestionAnsStatusRepo.findById(selectedQuestionId).orElse(null);
            if (selectQuestionAnsStatus != null) {
                selectQuestionAnsStatus.setSelectedQuestionId(selectQuestionAnsStatusDto.getSelectedQuestionId());
                selectQuestionAnsStatus.setUserId(selectQuestionAnsStatusDto.getUserId());
                selectQuestionAnsStatus.setSubject(selectQuestionAnsStatusDto.getSubject());
                selectQuestionAnsStatus.setAnsStatus(selectQuestionAnsStatusDto.getAnsStatus());
                selectQuestionAnsStatus.setDateTimeExamStart(selectQuestionAnsStatusDto.getDateTimeExamStart());
                selectQuestionAnsStatus.setDateAndTimeToEndExam(selectQuestionAnsStatusDto.getDateAndTimeToEndExam());
                return selectQuestionAnsStatusRepo.save(selectQuestionAnsStatus);
            }
        } catch (Exception e) {
            throw new ExamAnsnotFoundByIdException("SelectQuestionAnsStatus Not Found " + selectedQuestionId);
        }

        return null;
    }


}
