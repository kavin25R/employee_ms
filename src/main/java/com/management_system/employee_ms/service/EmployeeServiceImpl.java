package com.management_system.employee_ms.service;

import com.management_system.employee_ms.dto.employee.EmployeeCreateRequest;
import com.management_system.employee_ms.dto.employee.EmployeeResponse;
import com.management_system.employee_ms.dto.employee.EmployeeUpdateRequest;
import com.management_system.employee_ms.model.Employee;
import com.management_system.employee_ms.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse createEmployee(
            EmployeeCreateRequest request) {

        Employee employee = Employee.builder()
                .employeeCode(request.employeeCode())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .dateOfBirth(request.dateOfBirth())
                .joiningDate(request.joiningDate())
                .salary(request.salary())
                .build();

        Employee savedEmployee =
                employeeRepository.save(employee);

        return mapToResponse(savedEmployee);
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {

        Employee employee =
                employeeRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Employee not found: " + id
                                )
                        );

        return mapToResponse(employee);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public EmployeeResponse updateEmployee(
            Long id,
            EmployeeUpdateRequest request) {

        Employee employee =
                employeeRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Employee not found: " + id
                                )
                        );

        employee.setFirstName(request.firstName());
        employee.setLastName(request.lastName());
        employee.setEmail(request.email());
        employee.setPhone(request.phone());
        employee.setDateOfBirth(request.dateOfBirth());
        employee.setJoiningDate(request.joiningDate());
        employee.setSalary(request.salary());

        Employee updatedEmployee =
                employeeRepository.save(employee);

        return mapToResponse(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {

        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException(
                    "Employee not found: " + id
            );
        }

        employeeRepository.deleteById(id);
    }

    private EmployeeResponse mapToResponse(
            Employee employee) {

        return new EmployeeResponse(
                employee.getId(),
                employee.getEmployeeCode(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getDateOfBirth(),
                employee.getJoiningDate(),
                employee.getSalary(),
                employee.getStatus(),
                employee.getDepartment().getId(),
                employee.getDepartment().getName(),
                employee.getJobRole().getId(),
                employee.getJobRole().getTitle()
        );
    }
}