package com.infraoptix.infraoptix.domain.model.aggregate;

import com.infraoptix.infraoptix.domain.model.enums.ResourceStatus;
import com.infraoptix.infraoptix.domain.model.enums.ResourceType;
import java.math.BigDecimal;

public class CloudResource {

    private Long id;

    private String resourceId;

    private String resourceName;

    private ResourceType resourceType;

    private ResourceStatus status;

    private BigDecimal monthlyCost;

    private CloudResource(
            Long id,
            String resourceId,
            String resourceName,
            ResourceType resourceType,
            ResourceStatus status,
            BigDecimal monthlyCost) {

        this.id = id;
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.status = status;
        this.monthlyCost = monthlyCost;
    }
// Factory method to create a new CloudResource with default status as ACTIVE
    public static CloudResource create(
            String resourceId,
            String resourceName,
            ResourceType resourceType,
            BigDecimal monthlyCost) {

        return new CloudResource(
                null,
                resourceId,
                resourceName,
                resourceType,
                ResourceStatus.ACTIVE,
                monthlyCost
        );
    }

    public void stop() {
        this.status = ResourceStatus.STOPPED;
    }

    public void activate() {
        this.status = ResourceStatus.ACTIVE;
    }

    public ResourceStatus getStatus() {
        return status;
    }

    public String getResourceId() {
    return resourceId;
    }
    
    public String getResourceName() {
        return resourceName;
    }
    
    public ResourceType getResourceType() {
        return resourceType;
    }
    
    public BigDecimal getMonthlyCost() {
        return monthlyCost;
    }

    public Long getId() {
        return id;
    }

}
