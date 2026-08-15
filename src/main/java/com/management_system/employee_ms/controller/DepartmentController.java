package com.management_system.employee_ms.controller;

import com.management_system.employee_ms.model.Department;
import com.management_system.employee_ms.model.Employee;
import com.management_system.employee_ms.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dept")
public class DepartmentController {
    public final DepartmentService deptService;
    DepartmentController(DepartmentService deptService){
        this.deptService=deptService;
    }
    @PostMapping("/add")
    public Department add(@RequestBody Department dept){
        return deptService.add(dept);
    }
    @GetMapping("/view")
    public List<Department> view(){
        return deptService.view();
    }
    @PatchMapping("/update/{id}")
    public Department update(@PathVariable Long id,@RequestBody Department dept){
        return deptService.update(id,dept);
    }
    @GetMapping("/view/{id}")
    public Department viewById(@PathVariable Long id){
        return deptService.viewById(id);
    }
}
