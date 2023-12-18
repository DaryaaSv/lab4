package ua.nure.svyrydenko.mykolchuk.lab4.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.svyrydenko.mykolchuk.lab4.Models.Doctor;
import ua.nure.svyrydenko.mykolchuk.lab4.Repositories.DoctorRepository;

import java.util.Date;
import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Save a new doctor
    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Get doctor by ID
    public Doctor getDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId).orElse(null);
    }

    public String findMostExpensiveDoctor(Date date) {
        return "";
    }

}
