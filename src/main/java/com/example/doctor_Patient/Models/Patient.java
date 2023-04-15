package com.example.doctor_Patient.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(min = 3)
    private String name;

    @Size(max = 20, message = "{validation.name.size.too_long}")
    private String city;
    @Email
    private String email;
    @Size(min = 10)
    private String phoneNo;
    @NotNull
    private String symptom;
}
