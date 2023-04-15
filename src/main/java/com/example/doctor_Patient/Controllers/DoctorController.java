package com.example.doctor_Patient.Controllers;

import com.example.doctor_Patient.Dtos.DoctorEntryDto;
import com.example.doctor_Patient.Models.Doctor;
import com.example.doctor_Patient.Service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/add-doctor")
    public ResponseEntity<String> createDoctor(@Valid @RequestBody DoctorEntryDto doctorEntryDto){
        String ans=doctorService.createDoctor(doctorEntryDto);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);

    }

    @DeleteMapping("/delete-doctor")
    public ResponseEntity<String> deleteDoctor(@RequestParam("id")  Integer id){
        String ans=doctorService.deleteDoctor(id);
        return new ResponseEntity<>(ans,HttpStatus.OK);
    }
}
