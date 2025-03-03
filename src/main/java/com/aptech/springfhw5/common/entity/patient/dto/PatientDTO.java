package com.aptech.springfhw5.common.entity.patient.dto;

import com.aptech.springfhw5.common.entity.patient.Patient;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PatientDTO {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private Date dob;

    public PatientDTO(Patient patient) {
        this.id = patient.getId();
        this.fullName = patient.getFirstName() + ' ' + patient.getLastName();
        this.email = patient.getEmail();
        this.phone = patient.getPhone();
        this.dob = patient.getDob();
    }
}
