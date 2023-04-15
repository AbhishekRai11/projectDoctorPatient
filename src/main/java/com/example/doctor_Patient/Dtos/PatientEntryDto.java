package com.example.doctor_Patient.Dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PatientEntryDto {

    @NotNull
    private String name;

    @Max(20)
    private String city;


    @Email
    private String email;

    @Min(10)
    private String phoneNo;

    @NotNull
    private String symptom;


}
