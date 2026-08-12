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
    public Employee viewById(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee ID Not Found"));
    }
    public Employee update(Long id,Employee emp){
        Employee t=employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee Not found"));
        if(emp.getFirst_name()!=null){
            t.setFirst_name(emp.getFirst_name());
        }
        if(emp.getLast_name()!=null){
            t.setLast_name(emp.getLast_name());
        }
        if(emp.getEmail()!=null){
            t.setEmail(emp.getEmail());
        }
        if(emp.getPh_number()!=null){
            t.setPh_number(emp.getPh_number());
        }
        return employeeRepository.save(t);
    }
}
