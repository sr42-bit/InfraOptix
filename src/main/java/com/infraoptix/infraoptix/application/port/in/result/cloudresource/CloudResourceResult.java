package com.infraoptix.infraoptix.application.port.in.result.cloudresource;

import java.math.BigDecimal;

import com.infraoptix.infraoptix.domain.model.enums.ResourceStatus;
import com.infraoptix.infraoptix.domain.model.enums.ResourceType;

public record CloudResourceResult(
    String resourceId,
    String resourceName,
    ResourceType resourceType,
    ResourceStatus status,
    BigDecimal monthlyCost
) 
{}
