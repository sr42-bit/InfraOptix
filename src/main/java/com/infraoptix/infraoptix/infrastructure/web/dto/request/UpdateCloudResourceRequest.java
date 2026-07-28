package com.infraoptix.infraoptix.infrastructure.web.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UpdateCloudResourceRequest(

        @NotBlank(message = "Resource Name is required")
        String resourceName,

        @NotBlank(message = "Resource Type is required")
        String resourceType,

        @NotNull(message = "Monthly Cost is required")
        @Positive(message = "Monthly Cost must be greater than zero")
        BigDecimal monthlyCost

) {
}