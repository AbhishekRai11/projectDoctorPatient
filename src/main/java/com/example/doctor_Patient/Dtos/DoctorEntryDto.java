package com.example.doctor_Patient.Dtos;

import com.example.doctor_Patient.Enum.DoctorCity;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class DoctorEntryDto {
    @NotNull
    @Size(min = 3)
    private String name;
    //@Size(max = 20)
    private DoctorCity city;

    @Email
    private String email;
    @Size(min = 10)
    private String phoneNo;

    @NotNull
    private String specialist;

}
