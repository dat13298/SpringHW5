package com.aptech.springfhw5.common.entity.appointment;

import com.aptech.springfhw5.common.constant.EStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping
    public String appointments(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "status", required = false) EStatus status
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Appointment> appointments = appointmentService.findAll(pageable, keyword, status);
        model.addAttribute("appointments", appointments);
        model.addAttribute("keyword", keyword);
        model.addAttribute("status", status);
        model.addAttribute("statusList", EStatus.values());
        return "appointments";
    }
}
