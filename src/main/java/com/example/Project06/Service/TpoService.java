package com.example.Project06.Service;

import com.example.Project06.Dto.TpoDto.TpoDto;
import com.example.Project06.Entity.Tpo;

import java.util.List;

public interface TpoService {

    public String updateTpo(TpoDto tpoDto,Integer tpoId);
    public List<TpoDto> getAllTpo();

    public TpoDto getById(Integer tpoId);

    public String deleteById(Integer tpoId);

    public List<TpoDto> getByUserId(Integer userId);

}
