package com.infraoptix.infraoptix.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.infraoptix.infraoptix.domain.model.aggregate.CloudResource;
import com.infraoptix.infraoptix.infrastructure.persistence.jpa.entity.CloudResourceEntity;
@Component

public class CloudResourceMapper {
    
    public CloudResourceEntity toEntity(
            CloudResource cloudResource) {

        return CloudResourceEntity.builder()
                .id(cloudResource.getId())
                .resourceId(cloudResource.getResourceId())
                .resourceName(cloudResource.getResourceName())
                .resourceType(cloudResource.getResourceType())
                .status(cloudResource.getStatus())
                .monthlyCost(cloudResource.getMonthlyCost())
                .build();
    }

    public CloudResource toDomain(
            CloudResourceEntity entity) {

        return CloudResource.reconstruct(
                entity.getId(),
                entity.getResourceId(),
                entity.getResourceName(),
                entity.getResourceType(),
                entity.getStatus(),
                entity.getMonthlyCost()
        );
    }
}