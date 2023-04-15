package com.example.doctor_Patient.Models;

import com.example.doctor_Patient.Enum.DoctorCity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import java.util.ArrayList;

@Entity
@Table(name = "doctor")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private DoctorCity city;

    private String email;

    private String phoneNo;

    private ArrayList<String> specialistDisease=new ArrayList<>();


}
