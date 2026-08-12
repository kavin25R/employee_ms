package com.management_system.employee_ms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "name not blank")
    private String first_name;
    private String last_name;
    @Email
    private String email;
    @Size(max = 10,min = 10)
    private String ph_number;
    private String department;
    private String designation;
    private double salary;
    private Date join_date;
    private String status;

}
