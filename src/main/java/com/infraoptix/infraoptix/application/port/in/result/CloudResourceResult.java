package com.infraoptix.infraoptix.application.port.in.result;

import java.math.BigDecimal;

import com.infraoptix.infraoptix.domain.model.enums.ResourceType;
import com.infraoptix.infraoptix.domain.model.enums.ResourceStatus;

public record CloudResourceResult(
    String resourceId,
    String resourceName,
    ResourceType resourceType,
    ResourceStatus status,
    BigDecimal monthlyCost
) 
{}
