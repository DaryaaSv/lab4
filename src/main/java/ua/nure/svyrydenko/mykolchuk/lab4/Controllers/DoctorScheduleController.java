package ua.nure.svyrydenko.mykolchuk.lab4.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import ua.nure.svyrydenko.mykolchuk.lab4.DTOs.DoctorScheduleDTO;
import ua.nure.svyrydenko.mykolchuk.lab4.Models.Doctor;
import ua.nure.svyrydenko.mykolchuk.lab4.Models.DoctorSchedule;
import ua.nure.svyrydenko.mykolchuk.lab4.Services.DoctorScheduleService;
import ua.nure.svyrydenko.mykolchuk.lab4.Services.DoctorService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class DoctorScheduleController {

    @Autowired
    private DoctorScheduleService doctorScheduleService;

    @Autowired
    private DoctorService doctorsService;

    @GetMapping("/doctor_schedule")  // Specify the endpoint path
    public List<DoctorScheduleDTO> getAllDoctorSchedules() {
        List<DoctorSchedule> doctorSchedules = doctorScheduleService.getAllDoctorSchedules();
        return convertToDto(doctorSchedules);
    }

    private List<DoctorScheduleDTO> convertToDto(List<DoctorSchedule> doctorSchedules) {
        return doctorSchedules.stream()
                .map(doctorSchedule -> {
                    Doctor doctor = doctorsService.getDoctorById(doctorSchedule.getDoctor().getDoctorId());  // Fix method name
                    return new DoctorScheduleDTO(
                            doctor.getDoctorId(),
                            doctor.getFirstName() + " " + doctor.getLastName(),
                            doctorSchedule.getDayOfWeek(),
                            doctorSchedule.getStartTime(),
                            doctorSchedule.getEndTime()
                    );
                })
                .collect(Collectors.toList());  // Use Collectors.toList() to collect the stream
    }
}