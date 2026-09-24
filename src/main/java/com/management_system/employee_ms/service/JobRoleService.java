package com.management_system.employee_ms.service;

import com.management_system.employee_ms.dto.jobrole.JobRoleCreateRequest;
import com.management_system.employee_ms.dto.jobrole.JobRoleResponse;

import java.util.List;

public interface JobRoleService {

    JobRoleResponse createJobRole(JobRoleCreateRequest request);

    JobRoleResponse getJobRoleById(Long id);

    List<JobRoleResponse> getAllJobRoles();

    JobRoleResponse updateJobRole(Long id, JobRoleCreateRequest request);

    void deleteJobRole(Long id);
}