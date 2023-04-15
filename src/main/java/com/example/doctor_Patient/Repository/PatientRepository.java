package com.example.doctor_Patient.Repository;

import com.example.doctor_Patient.Models.Doctor;
import com.example.doctor_Patient.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
