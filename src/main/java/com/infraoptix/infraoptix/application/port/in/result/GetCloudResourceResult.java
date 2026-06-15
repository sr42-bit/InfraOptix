package com.infraoptix.infraoptix.application.port.in.result;

public record GetCloudResourceResult(
    Long resourceId,
    String resourceName,
    String resourceType,
    String status,
    Double monthlyCost
) {
}