package com.infraoptix.infraoptix.infrastructure.web.dto.response;

public record GetCloudResourceResponse(
    Long resourceId,
    String resourceName,
    String resourceType,
    String status,
    Double monthlyCost
) {
}