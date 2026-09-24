package com.management_system.employee_ms.service;

import com.management_system.employee_ms.dto.department.DepartmentCreateRequest;
import com.management_system.employee_ms.dto.department.DepartmentResponse;

import java.util.List;

public interface DepartmentService {

    DepartmentResponse createDepartment(DepartmentCreateRequest request);

    DepartmentResponse getDepartmentById(Long id);

    List<DepartmentResponse> getAllDepartments();

    DepartmentResponse updateDepartment(Long id, DepartmentCreateRequest request);

    void deleteDepartment(Long id);
}