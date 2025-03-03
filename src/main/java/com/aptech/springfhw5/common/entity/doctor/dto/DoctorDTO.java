package com.aptech.springfhw5.common.entity.doctor.dto;

import com.aptech.springfhw5.common.entity.doctor.Doctor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorDTO {
    private Long id;
    private String name;
    private String specialization;
    private String email;
    private String phone;

    public DoctorDTO(Doctor doctor) {
        this.id = doctor.getId();
        this.name = doctor.getName();
        this.specialization = doctor.getSpecialization();
        this.email = doctor.getEmail();
        this.phone = doctor.getPhone();
    }
}
