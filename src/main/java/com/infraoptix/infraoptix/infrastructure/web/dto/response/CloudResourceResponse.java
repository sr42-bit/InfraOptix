package com.infraoptix.infraoptix.infrastructure.web.dto.response;

import java.math.BigDecimal;

public record CloudResourceResponse(
        String resourceId,
        String resourceName,
        String resourceType,
        String status,
        BigDecimal monthlyCost
) {
}