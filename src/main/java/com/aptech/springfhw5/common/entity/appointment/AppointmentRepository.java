package com.aptech.springfhw5.common.entity.appointment;

import com.aptech.springfhw5.common.constant.EStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT a FROM Appointment a " +
            "JOIN FETCH a.doctor " +
            "JOIN FETCH a.patient " +
            "WHERE (:keyword IS NULL OR " +
            "LOWER(CONCAT(a.patient.firstName, ' ', a.patient.lastName)) " +
            "LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
            "OR (:status IS NULL OR a.status = :status)")
    Page<Appointment> searchAppointment(
            @Param("keyword") String keyword,
            @Param("status") EStatus status,
            Pageable pageable);
}
