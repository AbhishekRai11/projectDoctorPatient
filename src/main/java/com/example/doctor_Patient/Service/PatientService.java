package com.example.doctor_Patient.Service;

import com.example.doctor_Patient.Dtos.PatientEntryDto;
import com.example.doctor_Patient.Models.Doctor;
import com.example.doctor_Patient.Models.Patient;
import com.example.doctor_Patient.Repository.DoctorRepository;
import com.example.doctor_Patient.Repository.PatientRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService{
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository1;

    public String addPatient(Patient patient){



        patientRepository.save(patient);
        return "new Patient added";
    }

    public String deletePatient(Integer id){



        patientRepository.deleteById(id);
        return "new Patient added";
    }

    public Doctor assignDoctor(Integer id) throws Exception{
        Patient patient=patientRepository.findById(id).get();
        String city=patient.getCity();
        boolean isCity=false;


        String symptom=patient.getSymptom();
        //String city=patient.getCity();

        List<Doctor> doctorList=doctorRepository1.findAll();

        for(Doctor doctor: doctorList){
            if(city.equalsIgnoreCase(doctor.getCity().toString())){
                isCity=true;
                ArrayList<String> disease=doctor.getSpecialistDisease();

                if(disease!=null && disease.contains(symptom)){
                    return doctor;
                }

            }
        }
        if(isCity){
            Doctor doctor=new Doctor();
            doctor.setName("There isn’t any doctor present at your location for your symptom");
            return doctor;
        }
        else {
            Doctor doctor=new Doctor();
            doctor.setName("We are still waiting to expand to your location");
            return doctor;
        }





    }
}
