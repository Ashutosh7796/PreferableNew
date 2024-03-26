package com.example.Project06.ServiceImpl;
import com.example.Project06.Dto.TpoDto.TpoDto;
import com.example.Project06.Entity.Tpo;
import com.example.Project06.Entity.User;
import com.example.Project06.Entity.UserPlan;
import com.example.Project06.Repository.TpoRepo;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.TpoService;
import com.example.Project06.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class TpoServiceImpl implements TpoService {
    @Autowired
    private TpoRepo tpoRepo;
    @Autowired
    private UserRepository userRepository;

     @Override
    public List<TpoDto> getAllTpo() {
         List<Tpo> tpos = tpoRepo.findAll();
         return tpos.stream()
                 .map(TpoDto::new)
                 .collect(Collectors.toList());
    }

    @Override
    public TpoDto getById(Integer tpoId) {
        Optional<Tpo> tpo = tpoRepo.findById(tpoId);
        if (tpo.isEmpty()) {
            throw new TpoNotFoundException("Tpo not found", HttpStatus.NOT_FOUND);
        }
        TpoDto tpoDto = new TpoDto(tpo.get());
        tpoDto.setTpoId(tpoId);

        return tpoDto;
    }


    @Override
    public String deleteById(Integer tpoId) {
        Optional<Tpo> byId = this.tpoRepo.findById(tpoId);
        if (byId.isPresent()) {
            tpoRepo.deleteById(tpoId);
            return "Tpo deleted successfully";
        } else {
            throw new TpoNotFoundException("Tpo Not Found ", HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public List<TpoDto> getByUserId(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            throw new UserNotFoundExceptions("User Not Found");
        }

        User user = userOptional.get();
        List<Tpo> tpos = tpoRepo.findByUserUser(userId);

        if (tpos.isEmpty()) {
            throw new NoSavedTpoFoundException("Tpo not found for given UserId");
        }

        return tpos.stream()
                .map(TpoDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public String updateTpo(TpoDto tpoDto, Integer tpoId) {
        try {
            Tpo tpo = tpoRepo.findById(tpoId).orElse(null);

            if (tpo != null) {

                tpo.setCollageName(tpoDto.getCollageName());
                tpo.setAddress(tpoDto.getAddress());
                tpo.setState(tpoDto.getState());
                tpo.setDist(tpoDto.getDist());
                tpo.setCity(tpoDto.getCity());
                tpo.setPincode(tpoDto.getPincode());
                tpo.setType(tpoDto.getType());
                tpo.setDate(tpoDto.getDate());
                tpo.setEstablishedDate(tpoDto.getEstablishedDate());

                tpoRepo.save(tpo);
            }
        } catch (Exception e) {

        }
        return null;

    }


}
