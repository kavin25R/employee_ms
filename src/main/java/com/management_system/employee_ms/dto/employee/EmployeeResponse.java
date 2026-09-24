package com.management_system.employee_ms.dto.employee;

import com.management_system.employee_ms.model.EmployeeStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeResponse(

        Long id,

        String employeeCode,

        String firstName,

        String lastName,

        String email,

        String phone,

        LocalDate dateOfBirth,

        LocalDate joiningDate,

        BigDecimal salary,

        EmployeeStatus status,

        Long departmentId,

        String departmentName,

        Long jobRoleId,

        String jobRoleTitle
) {
}