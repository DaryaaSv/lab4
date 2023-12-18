package ua.nure.svyrydenko.mykolchuk.lab4.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.svyrydenko.mykolchuk.lab4.Models.DoctorSchedule;
import ua.nure.svyrydenko.mykolchuk.lab4.Repositories.DoctorScheduleRepository;

import java.util.List;

@Service
public class DoctorScheduleService {

    private final DoctorScheduleRepository doctorScheduleRepository;

    @Autowired
    public DoctorScheduleService(DoctorScheduleRepository doctorScheduleRepository) {
        this.doctorScheduleRepository = doctorScheduleRepository;
    }

    public List<DoctorSchedule> getAllDoctorSchedules() {
        return doctorScheduleRepository.findAll();
    }

    public DoctorSchedule getDoctorScheduleById(Long scheduleId) {
        return doctorScheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("Doctor Schedule not found with ID: " + scheduleId));
    }

    public void saveDoctorSchedule(DoctorSchedule doctorSchedule) {
        doctorScheduleRepository.save(doctorSchedule);
    }

    public void deleteDoctorSchedule(Long scheduleId) {
        doctorScheduleRepository.deleteById(scheduleId);
    }

}
