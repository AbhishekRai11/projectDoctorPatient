package com.example.doctor_Patient.Controllers;

import com.example.doctor_Patient.Dtos.PatientEntryDto;
import com.example.doctor_Patient.Models.Doctor;
import com.example.doctor_Patient.Models.Patient;
import com.example.doctor_Patient.Service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/add-patient")
    public ResponseEntity<String> addPatient(@Valid @RequestBody Patient patient){

        String ans= patientService.addPatient(patient);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-patient")
    public ResponseEntity<String> deletePatient(@RequestParam("id") Integer id){

        String ans= patientService.deletePatient(id);
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @GetMapping("/assign-doctor")
    public ResponseEntity<Doctor> assignDoctor(@RequestParam("id") Integer id) throws Exception{
        Doctor doctor =patientService.assignDoctor(id);
        return new ResponseEntity<>(doctor,HttpStatus.OK);
    }
}
