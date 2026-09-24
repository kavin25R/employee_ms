package com.management_system.employee_ms.service;

import com.management_system.employee_ms.dto.employee.EmployeeCreateRequest;
import com.management_system.employee_ms.dto.employee.EmployeeResponse;
import com.management_system.employee_ms.dto.employee.EmployeeUpdateRequest;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse createEmployee(
            EmployeeCreateRequest request
    );

    EmployeeResponse getEmployeeById(
            Long id
    );

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse updateEmployee(
            Long id,
            EmployeeUpdateRequest request
    );

    void deleteEmployee(Long id);
}