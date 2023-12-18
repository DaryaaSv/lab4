package ua.nure.svyrydenko.mykolchuk.lab4.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.nure.svyrydenko.mykolchuk.lab4.DTOs.AppointmentDTO;
import ua.nure.svyrydenko.mykolchuk.lab4.Services.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointments")
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

}

