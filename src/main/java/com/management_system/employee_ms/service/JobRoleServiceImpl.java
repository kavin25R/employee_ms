package com.management_system.employee_ms.service;

import com.management_system.employee_ms.dto.jobrole.JobRoleCreateRequest;
import com.management_system.employee_ms.dto.jobrole.JobRoleResponse;
import com.management_system.employee_ms.model.JobRole;
import com.management_system.employee_ms.repository.JobRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class JobRoleServiceImpl implements JobRoleService {

    private final JobRoleRepository jobRoleRepository;

    @Override
    public JobRoleResponse createJobRole(JobRoleCreateRequest request) {

        if (jobRoleRepository.existsByTitle(request.title())) {
            throw new RuntimeException("Job role already exists");
        }

        JobRole jobRole = new JobRole();

        jobRole.setTitle(request.title());
        jobRole.setDescription(request.description());

        JobRole savedJobRole = jobRoleRepository.save(jobRole);

        return mapToResponse(savedJobRole);
    }

    @Override
    @Transactional(readOnly = true)
    public JobRoleResponse getJobRoleById(Long id) {

        JobRole jobRole = jobRoleRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Job role not found with id: " + id));

        return mapToResponse(jobRole);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JobRoleResponse> getAllJobRoles() {

        return jobRoleRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public JobRoleResponse updateJobRole(
            Long id,
            JobRoleCreateRequest request) {

        JobRole jobRole = jobRoleRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Job role not found with id: " + id));

        jobRole.setTitle(request.title());
        jobRole.setDescription(request.description());

        JobRole updatedJobRole = jobRoleRepository.save(jobRole);

        return mapToResponse(updatedJobRole);
    }

    @Override
    public void deleteJobRole(Long id) {

        JobRole jobRole = jobRoleRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Job role not found with id: " + id));

        jobRoleRepository.delete(jobRole);
    }

    private JobRoleResponse mapToResponse(JobRole jobRole) {

        return new JobRoleResponse(
                jobRole.getId(),
                jobRole.getTitle(),
                jobRole.getDescription()
        );
    }
}