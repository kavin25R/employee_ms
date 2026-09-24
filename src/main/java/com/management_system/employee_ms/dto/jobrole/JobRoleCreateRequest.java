package com.management_system.employee_ms.dto.jobrole;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record JobRoleCreateRequest(

        @NotBlank(message = "Job title is required")
        @Size(max = 100)
        String title,

        @Size(max = 500)
        String description
) {
}