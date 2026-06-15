package com.infraoptix.infraoptix.application.port.in.command;

import java.math.BigDecimal;

import com.infraoptix.infraoptix.domain.model.enums.ResourceType;

public record CreateCloudResourceCommand(
        String resourceId,
        String resourceName,
        ResourceType resourceType,
        BigDecimal monthlyCost
) {
    
}
