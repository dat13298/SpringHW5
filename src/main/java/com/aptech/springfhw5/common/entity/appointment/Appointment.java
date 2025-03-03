package com.aptech.springfhw5.common.entity.appointment;

import com.aptech.springfhw5.common.constant.EStatus;
import com.aptech.springfhw5.common.entity.AbstractEntity;
import com.aptech.springfhw5.common.entity.doctor.Doctor;
import com.aptech.springfhw5.common.entity.patient.Patient;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@Table(name = "appointments")
@AllArgsConstructor
@NoArgsConstructor
public class Appointment extends AbstractEntity<Long, Appointment> {

    @NotNull(message = "Appointment date not null")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date appointmentDate;

    @Enumerated(EnumType.STRING)
    private EStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    @NotNull(message = "Patient not null")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    @NotNull(message = "Doctor not null")
    private Doctor doctor;
}
