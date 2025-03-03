package com.aptech.springfhw5.common.entity.appointment;

import com.aptech.springfhw5.common.constant.EStatus;
import com.aptech.springfhw5.common.entity.appointment.dto.AppointmentDTO;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT a FROM Appointment a " +
            "JOIN FETCH a.doctor " +
            "JOIN FETCH a.patient " +
            "WHERE (:keyword IS NULL OR " +
            "LOWER(CONCAT(a.patient.firstName, ' ', a.patient.lastName)) " +
            "LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
            "AND (:status IS NULL OR a.status = :status)")
    Page<Appointment> searchAppointment(
            @Param("keyword") String keyword,
            @Param("status") EStatus status,
            Pageable pageable);

    List<Appointment> findByAppointmentDate(@NotNull(message = "Appointment date not null") Date appointmentDate);
}
