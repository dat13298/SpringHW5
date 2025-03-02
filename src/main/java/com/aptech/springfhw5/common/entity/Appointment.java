package com.aptech.springfhw5.common.entity;

import com.aptech.springfhw5.common.constant.EStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
    private Date appointmentDate;
    private EStatus status;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @NotNull(message = "Patient not null")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @NotNull(message = "Doctor not null")
    private Doctor doctor;
}
