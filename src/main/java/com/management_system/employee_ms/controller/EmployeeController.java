package com.management_system.employee_ms.controller;

import com.management_system.employee_ms.model.Employee;
import com.management_system.employee_ms.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
    public static EmployeeService employeeService;
    EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @PostMapping("/add")
    public Employee adding(@RequestBody Employee employee){
        return employeeService.adding(employee);
    }
    @GetMapping("/view")
    public List<Employee> view(){
        return employeeService.view();
    }
    @GetMapping("/view/{id}")
    public Employee viewbyId(@PathVariable Long id){
        return employeeService.viewById(id);
    }
    @PatchMapping("/update/{id}")
    public Employee update(@PathVariable Long id,@RequestBody Employee emp){
        return employeeService.update(id,emp);
    }
}
