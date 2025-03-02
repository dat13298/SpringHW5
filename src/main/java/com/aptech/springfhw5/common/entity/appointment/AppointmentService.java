package com.aptech.springfhw5.common.entity.appointment;

import com.aptech.springfhw5.common.constant.EStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public Page<Appointment> findAll(Pageable pageable, String keyword, EStatus status) {
        PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by("createdDate").descending()
        );
        return appointmentRepository.searchAppointment(keyword, status ,pageable);
    }
}
