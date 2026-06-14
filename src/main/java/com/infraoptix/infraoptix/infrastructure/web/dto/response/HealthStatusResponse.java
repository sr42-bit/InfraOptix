package com.infraoptix.infraoptix.infrastructure.web.dto.response;

public record HealthStatusResponse(
    String status,
    String service
) {}