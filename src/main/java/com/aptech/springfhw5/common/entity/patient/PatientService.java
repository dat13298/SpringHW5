package com.aptech.springfhw5.common.entity.patient;

import com.aptech.springfhw5.common.entity.patient.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<PatientDTO> findAll() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(PatientDTO::new).collect(Collectors.toList());
    }

    public Patient findById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }
}
