package com.management_system.employee_ms.repository;

import com.management_system.employee_ms.model.JobRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobRoleRepository
        extends JpaRepository<JobRole, Long> {

    Optional<JobRole> findByTitle(String title);

    boolean existsByTitle(String title);
}