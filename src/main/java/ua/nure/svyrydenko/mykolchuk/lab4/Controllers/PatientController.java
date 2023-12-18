package ua.nure.svyrydenko.mykolchuk.lab4.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.nure.svyrydenko.mykolchuk.lab4.Models.Patient;
import ua.nure.svyrydenko.mykolchuk.lab4.Repositories.PatientRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getAllDoctors() {
        return patientRepository.findAll();
    }

    @PostMapping("/patients")
    public Patient addDoctor(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

}
