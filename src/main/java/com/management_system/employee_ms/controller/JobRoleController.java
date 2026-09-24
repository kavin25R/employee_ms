package com.management_system.employee_ms.controller;

import com.management_system.employee_ms.dto.jobrole.JobRoleCreateRequest;
import com.management_system.employee_ms.dto.jobrole.JobRoleResponse;
import com.management_system.employee_ms.service.JobRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-roles")
@RequiredArgsConstructor
public class JobRoleController {

    private final JobRoleService jobRoleService;

    @PostMapping
    public ResponseEntity<JobRoleResponse> createJobRole(
            @Valid @RequestBody JobRoleCreateRequest request) {

        JobRoleResponse response =
                jobRoleService.createJobRole(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobRoleResponse> getJobRoleById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                jobRoleService.getJobRoleById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<JobRoleResponse>> getAllJobRoles() {

        return ResponseEntity.ok(
                jobRoleService.getAllJobRoles()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobRoleResponse> updateJobRole(
            @PathVariable Long id,
            @Valid @RequestBody JobRoleCreateRequest request) {

        return ResponseEntity.ok(
                jobRoleService.updateJobRole(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobRole(
            @PathVariable Long id) {

        jobRoleService.deleteJobRole(id);

        return ResponseEntity.noContent().build();
    }
}