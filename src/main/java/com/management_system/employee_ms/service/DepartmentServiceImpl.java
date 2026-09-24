package com.management_system.employee_ms.service;

import com.management_system.employee_ms.dto.department.DepartmentCreateRequest;
import com.management_system.employee_ms.dto.department.DepartmentResponse;
import com.management_system.employee_ms.model.Department;
import com.management_system.employee_ms.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponse createDepartment(DepartmentCreateRequest request) {

        if (departmentRepository.existsByName(request.name())) {
            throw new RuntimeException("Department already exists");
        }

        Department department = new Department();

        department.setName(request.name());
        department.setDescription(request.description());

        Department savedDepartment = departmentRepository.save(department);

        return mapToResponse(savedDepartment);
    }

    @Override
    @Transactional(readOnly = true)
    public DepartmentResponse getDepartmentById(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Department not found with id: " + id));

        return mapToResponse(department);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DepartmentResponse> getAllDepartments() {

        return departmentRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public DepartmentResponse updateDepartment(
            Long id,
            DepartmentCreateRequest request) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Department not found with id: " + id));

        department.setName(request.name());
        department.setDescription(request.description());

        Department updatedDepartment = departmentRepository.save(department);

        return mapToResponse(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Department not found with id: " + id));

        departmentRepository.delete(department);
    }

    private DepartmentResponse mapToResponse(Department department) {

        return new DepartmentResponse(
                department.getId(),
                department.getName(),
                department.getDescription()
        );
    }
}