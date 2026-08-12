package com.management_system.employee_ms.service;

import com.management_system.employee_ms.model.Employee;
import com.management_system.employee_ms.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    public final EmployeeRepository employeeRepository;
    EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    public Employee adding(Employee emp){
        return employeeRepository.save(emp);
    }
    public List<Employee> view(){
        return employeeRepository.findAll();
    }
}
