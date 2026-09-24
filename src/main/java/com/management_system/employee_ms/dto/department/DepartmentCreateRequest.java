package com.management_system.employee_ms.dto.department;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DepartmentCreateRequest(

        @NotBlank(message = "Department name is required")
        @Size(max = 100)
        String name,

        @Size(max = 500)
        String description
) {
}