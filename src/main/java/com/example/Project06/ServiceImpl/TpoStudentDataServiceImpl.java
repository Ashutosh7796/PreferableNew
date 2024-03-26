package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.TpoStudentDataDto;
import com.example.Project06.Entity.*;
import com.example.Project06.Repository.TpoStudentDataRepo;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.TpoStudentDataService;
import com.example.Project06.exception.TpoNotFoundException;
import com.example.Project06.exception.TpoStudentDataIsNotfoundException;
import com.example.Project06.exception.UserNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TpoStudentDataServiceImpl implements TpoStudentDataService {

    @Autowired
    TpoStudentDataRepo tpoStudentDataRepo;

    @Autowired
    UserRepository userRepository;

    @Override
    public String addTpoStudentData(TpoStudentDataDto tpoStudentDataDto, Integer userId) {
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isPresent()) {
            TpoStudentData tpoStudentData = new TpoStudentData(tpoStudentDataDto);
            tpoStudentData.setUserId(byId.get().getUser_id());
            tpoStudentDataRepo.save(tpoStudentData);
            return "TpoStudentData added successfully";
        }

        return "User Not Found";
    }

    @Override
    public TpoStudentDataDto getByTpoStudentDataById(Integer tpoStudentData/*, Integer userId*/) {
        Optional<TpoStudentData> tpoStudentData1 = tpoStudentDataRepo.findById(tpoStudentData);
        if (tpoStudentData1.isEmpty()) {
            throw new TpoStudentDataIsNotfoundException("Not Found", HttpStatus.NOT_FOUND);
        }
        TpoStudentDataDto tpoStudentDataDto = new TpoStudentDataDto(tpoStudentData1.get());
        tpoStudentDataDto.setTpoStudentData(tpoStudentData);
        return tpoStudentDataDto;
    }

    @Override
    public List<TpoStudentDataDto> getAllTpoStudentData() {
        List<TpoStudentData> tpoStudentData = tpoStudentDataRepo.findAll();
        return tpoStudentData.stream()
                .map(TpoStudentDataDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteById(Integer tpoStudentData) {
        Optional<TpoStudentData> byId = this.tpoStudentDataRepo.findById(tpoStudentData);
        if (byId.isPresent()) {
            tpoStudentDataRepo.deleteById(tpoStudentData);
            return "TpoStudentData deleted successfully";
        } else {
            throw new TpoNotFoundException("TpoStudentData Not Found ", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public String updateTpoStudentData(TpoStudentDataDto tpoStudentDataDto, Integer tpoStudentData) {
        try {
            TpoStudentData tpoStudentData1 = tpoStudentDataRepo.findById(tpoStudentData).orElseThrow(null);
            if (tpoStudentData1 != null) {

                tpoStudentData1.setUserId(tpoStudentDataDto.getUserId());
                tpoStudentData1.setTestName(tpoStudentDataDto.getTestName());
                tpoStudentData1.setTotalMarks(tpoStudentDataDto.getTotalMarks());
                tpoStudentData1.setMarks(tpoStudentDataDto.getMarks());
                tpoStudentData1.setResult(tpoStudentDataDto.getResult());
                tpoStudentData1.setTpoStudentDatacol(tpoStudentDataDto.getTpoStudentDatacol());

                tpoStudentDataRepo.save(tpoStudentData1);
            }
        } catch (Exception e) {

        }
        return "updated Successfully";
    }

    @Override
    public List<TpoStudentDataDto> getByUserId(Integer userId) {
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isEmpty()) {
            throw new UserNotFoundExceptions("User not found");
        }
        User user = byId.get();
        List<TpoStudentData> byuserId = tpoStudentDataRepo.findByuserId(userId);
        if(byuserId.isEmpty()) {
            throw new TpoStudentDataIsNotfoundException("Record is not found with given userId", HttpStatus.NOT_FOUND);
        }
        return byuserId.stream()
                .map(TpoStudentDataDto::new)
                .collect(Collectors.toList());

    }
}
