package ua.nure.svyrydenko.mykolchuk.lab4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.nure.svyrydenko.mykolchuk.lab4.Models.Doctor;
import ua.nure.svyrydenko.mykolchuk.lab4.Services.DoctorService;

import java.util.List;

@SpringBootApplication
public class Lab4Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab4Application.class, args);

//        ConfigurableApplicationContext context = SpringApplication.run(Lab4Application.class, args);
//
//        // Get the DoctorService bean
//        DoctorService doctorService = context.getBean(DoctorService.class);
//
//        // Example: Retrieve all doctors
//        List<Doctor> allDoctors = doctorService.getAllDoctors();
//        for(int i=0; i < allDoctors.size(); i++) {
//            System.out.println(allDoctors.get(i).toString());
//        }
//        System.out.println("All Doctors: " + allDoctors);
//
//        // Example: Retrieve doctor by ID
//        Long doctorId = 1L;
//        Doctor doctorById = doctorService.getDoctorById(doctorId);
//        System.out.println("Doctor with ID " + doctorId + ": " + doctorById.toString());
//
////        // Example: Retrieve doctors by specialty
////        String specialty = "Cardiology";
////        List<Doctor> doctorsBySpecialty = doctorService.getDoctorsBySpecialty(specialty);
////        System.out.println("Doctors with Specialty " + specialty + ": " + doctorsBySpecialty);
//
//        // Close the application context
//        context.close();
    }

}
