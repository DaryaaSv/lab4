package ua.nure.svyrydenko.mykolchuk.lab4.Services;

import org.springframework.stereotype.Service;
import ua.nure.svyrydenko.mykolchuk.lab4.DTOs.AppointmentDTO;
import ua.nure.svyrydenko.mykolchuk.lab4.Models.Appointment;
import ua.nure.svyrydenko.mykolchuk.lab4.Repositories.AppointmentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<AppointmentDTO> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return convertToDto(appointments);
    }

    private List<AppointmentDTO> convertToDto(List<Appointment> appointments) {
        return appointments.stream()
                .map(appointment -> new AppointmentDTO(
                        appointment.getAppointmentId(),
                        appointment.getAppointmentType(),
                        appointment.getAppointmentDate(),
                        appointment.getAppointmentPrice(),
                        appointment.getPatient().getFirstName(),
                        appointment.getPatient().getLastName(),
                        appointment.getDoctor().getFirstName(),
                        appointment.getDoctor().getLastName()
                ))
                .collect(Collectors.toList());
    }
}
