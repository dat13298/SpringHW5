package com.aptech.springfhw5.common.entity.appointment;

import com.aptech.springfhw5.common.constant.EStatus;
import com.aptech.springfhw5.common.entity.appointment.dto.AppointmentDTO;
import com.aptech.springfhw5.common.entity.doctor.Doctor;
import com.aptech.springfhw5.common.entity.doctor.DoctorService;
import com.aptech.springfhw5.common.entity.patient.Patient;
import com.aptech.springfhw5.common.entity.patient.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorService doctorService;
    private final PatientService patientService;

    public Page<AppointmentDTO> findAll(Pageable pageable, String keyword, EStatus status) {
        PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by("createdDate").descending()
        );

        Page<Appointment> appointments = appointmentRepository.searchAppointment(keyword, status, pageRequest);

        return appointments.map(this::convertToDTO);
    }

    private AppointmentDTO convertToDTO(Appointment appointment) {
        return new AppointmentDTO(appointment);
    }

    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }

    public boolean isDoctorHasAppointment(Long doctorId, Date appointmentDate) {
        List<Appointment> result = appointmentRepository.findByAppointmentDate(appointmentDate);
        return result.stream().anyMatch(a -> a.getDoctor().getId().equals(doctorId));
    }

    public boolean save(AppointmentDTO appointmentDTO, EStatus status) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setStatus(status);

        Patient patient = patientService.findById(appointmentDTO.getPatientDTO().getId());

        if(patient == null) {
            return false;
        }
        appointment.setPatient(patient);

        Doctor doctor = doctorService.findDoctorById(appointmentDTO.getDoctorDTO().getId());
        if(doctor == null) {
            return false;
        }
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);
        return true;
    }
}
