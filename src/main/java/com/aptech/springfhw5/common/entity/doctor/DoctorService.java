package com.aptech.springfhw5.common.entity.doctor;

import com.aptech.springfhw5.common.entity.doctor.dto.DoctorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public List<DoctorDTO> findAll() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(DoctorDTO::new).collect(Collectors.toList());
    }
}
