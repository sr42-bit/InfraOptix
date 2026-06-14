package com.infraoptix.infraoptix.infrastructure.web.dto.request;

import java.math.BigDecimal;

public record CreateCloudResourceRequest(
        String resourceId,
        String resourceName,
        String resourceType,
        BigDecimal monthlyCost
) {
}
