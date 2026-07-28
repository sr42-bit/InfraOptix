package com.infraoptix.infraoptix.application.port.in.command.cloudresource;

import java.math.BigDecimal;

import com.infraoptix.infraoptix.domain.model.enums.ResourceStatus;
import com.infraoptix.infraoptix.domain.model.enums.ResourceType;

public record UpdateCloudResourceCommand(

        Long id,

        String resourceName,

        ResourceType resourceType,

        ResourceStatus status,

        BigDecimal monthlyCost

) {
}