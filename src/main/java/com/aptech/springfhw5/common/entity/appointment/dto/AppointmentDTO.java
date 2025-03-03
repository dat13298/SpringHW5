package com.aptech.springfhw5.common.entity.appointment.dto;

import com.aptech.springfhw5.common.constant.EStatus;
import com.aptech.springfhw5.common.entity.appointment.Appointment;
import com.aptech.springfhw5.common.entity.doctor.dto.DoctorDTO;
import com.aptech.springfhw5.common.entity.patient.dto.PatientDTO;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentDTO {

    private Long id;

    @NotNull(message = "Appointment date not null")
    @Future(message = "Event name cannot be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date appointmentDate;

    private EStatus status;

    @NotNull(message = "Patient not null")
    private PatientDTO patientDTO;

    @NotNull(message = "Patient not null")
    private DoctorDTO doctorDTO;

    private String specialization;

    public AppointmentDTO(Appointment appointment) {
        this.id = appointment.getId();
        this.appointmentDate = appointment.getAppointmentDate();
        this.status = appointment.getStatus();
        this.patientDTO = new PatientDTO(appointment.getPatient());
        this.doctorDTO = new DoctorDTO(appointment.getDoctor());
        this.specialization = appointment.getDoctor().getSpecialization();
    }
}
