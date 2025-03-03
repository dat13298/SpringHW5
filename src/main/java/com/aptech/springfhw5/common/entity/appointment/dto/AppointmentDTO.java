package com.aptech.springfhw5.common.entity.appointment.dto;

import com.aptech.springfhw5.common.constant.EStatus;
import com.aptech.springfhw5.common.entity.appointment.Appointment;
import com.aptech.springfhw5.common.entity.doctor.dto.DoctorDTO;
import com.aptech.springfhw5.common.entity.patient.dto.PatientDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentDTO {
    private Long id;
    @NotNull(message = "Appointment date not null")
    private Date appointmentDate;
    private EStatus status;
    private PatientDTO patientDTO;
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
