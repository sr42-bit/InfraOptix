package com.infraoptix.infraoptix.application.port.in.command;

import com.infraoptix.infraoptix.domain.model.enums.ResourceType;

import java.math.BigDecimal;

public record CreateCloudResourceCommand(
        String resourceId,
        String resourceName,
        ResourceType resourceType,
        BigDecimal monthlyCost
) {
    
}
