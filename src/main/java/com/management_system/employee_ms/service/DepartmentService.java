package com.management_system.employee_ms.service;

import com.management_system.employee_ms.exception.EmployeeException;
import com.management_system.employee_ms.model.Department;
import com.management_system.employee_ms.model.Employee;
import com.management_system.employee_ms.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    public final DepartmentRepository deptRepository;
    DepartmentService(DepartmentRepository deptRepository){
        this.deptRepository=deptRepository;
    }
    public Department add(Department department){
        return deptRepository.save(department);
    }
    public List<Department> view(){
        return deptRepository.findAll();
    }
    public  Department viewById(Long id){
        return deptRepository.findById(id).orElseThrow(()-> new EmployeeException("Department not found"));
    }
    public Department update(Long id,Department dept){
        Department t=deptRepository.findById(id).orElseThrow(()->new EmployeeException("Department Not found"));
        if(dept.getName()!=null){
            t.setName(dept.getName());
        }
        if(dept.getDescription()!=null){
            t.setDescription(dept.getDescription());
        }
        if(dept.getLocation()!=null){
            t.setLocation(dept.getLocation());
        }
        return deptRepository.save(t);
    }
}
