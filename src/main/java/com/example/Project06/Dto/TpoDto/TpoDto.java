package com.example.Project06.Dto.TpoDto;

import com.example.Project06.Entity.Tpo;
import com.example.Project06.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@ToString
@Builder
public class TpoDto {
    private Integer tpoId;
    private String collageName;
    private String address;
    private String state;
    private String dist;
    private String city;
    private String pincode;
    private String type;
    private LocalDate date;
    private LocalDate establishedDate;
    private Integer user_id;

    public TpoDto(Tpo tpo){

        this.tpoId = tpo.getTpoId();
        this.collageName =tpo.getCollageName();
        this.address = tpo.getAddress();
        this.state = tpo.getState();
        this.dist = tpo.getDist();
        this.city = tpo.getCity();
        this.pincode = tpo.getPincode();
        this.type = tpo.getType();
        this.date = tpo.getDate();
        this.establishedDate = tpo.getEstablishedDate();
        this.user_id = tpo.getUserUser().getUser_id();
    }

}
