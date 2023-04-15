package com.example.doctor_Patient.Service;

import com.example.doctor_Patient.Dtos.DoctorEntryDto;
import com.example.doctor_Patient.Models.Doctor;
import com.example.doctor_Patient.Models.Specialist;
import com.example.doctor_Patient.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public String createDoctor(DoctorEntryDto doctorEntryDto){
        Doctor doctor=Doctor.builder()
                .name(doctorEntryDto.getName())
                .city(doctorEntryDto.getCity())
                .email(doctorEntryDto.getEmail())
                .phoneNo(doctorEntryDto.getPhoneNo())
                .build();
//        Specialist s=new Specialist();
        HashMap<String, ArrayList<String>> specialist= new HashMap<>();


        ArrayList<String> orthopedicDisease=new ArrayList<>();
        orthopedicDisease.add("Arthritis");
        orthopedicDisease.add("Backpain");
        orthopedicDisease.add("Tissue injuries");

        specialist.put("Orthopodia",orthopedicDisease);

        ArrayList<String> gynecologyDiesease=new ArrayList<>();
        gynecologyDiesease.add("Dysmenorrhea");

        specialist.put("Gynecology",gynecologyDiesease);


        ArrayList<String> dermatologyDiesease=new ArrayList<>();
        dermatologyDiesease.add("Skin infection");
        dermatologyDiesease.add("skin burn");

        specialist.put("Dermatology",dermatologyDiesease);


        ArrayList<String> ENTDiesease=new ArrayList<>();
        ENTDiesease.add("Ear pain");
        ENTDiesease.add("Eye pain");

        specialist.put("ENT",ENTDiesease);


        for(String spe: specialist.keySet()){
            if(spe.equalsIgnoreCase(doctorEntryDto.getSpecialist())){
                doctor.setSpecialistDisease(specialist.get(spe));
                break;
            }
        }


        //doctor.setSpecialistDisease(gynecologyDiesease);

        doctorRepository.save(doctor);

        return "doctor created";
    }

    public String deleteDoctor(Integer id){
        doctorRepository.deleteById(id);
        return "doctor deleted";
    }
}
