package com.aptech.springfhw5.common.entity.appointment;

import com.aptech.springfhw5.common.constant.EStatus;
import com.aptech.springfhw5.common.entity.appointment.dto.AppointmentDTO;
import com.aptech.springfhw5.common.entity.doctor.Doctor;
import com.aptech.springfhw5.common.entity.doctor.DoctorService;
import com.aptech.springfhw5.common.entity.doctor.dto.DoctorDTO;
import com.aptech.springfhw5.common.entity.patient.Patient;
import com.aptech.springfhw5.common.entity.patient.PatientService;
import com.aptech.springfhw5.common.entity.patient.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final DoctorService doctorService;

    @GetMapping
    public String appointments(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "status", required = false) EStatus status
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AppointmentDTO> appointments = appointmentService.findAll(pageable, keyword, status);
        model.addAttribute("appointments", appointments);
        model.addAttribute("keyword", keyword);
        model.addAttribute("status", status);
        model.addAttribute("statusList", EStatus.values());
        return "appointments";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        appointmentService.delete(id);
        return "redirect:/appointments";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("appointment", new AppointmentDTO());
        List<PatientDTO> patients = patientService.findAll();
        model.addAttribute("patients", patients);
        List<DoctorDTO> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "addAppointment";
    }
}
