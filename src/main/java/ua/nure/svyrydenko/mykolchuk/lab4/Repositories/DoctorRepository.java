package ua.nure.svyrydenko.mykolchuk.lab4.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.svyrydenko.mykolchuk.lab4.Models.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
