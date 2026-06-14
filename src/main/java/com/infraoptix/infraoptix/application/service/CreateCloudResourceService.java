package com.infraoptix.infraoptix.application.service;

import org.springframework.stereotype.Service;

import com.infraoptix.infraoptix.application.port.in.command.CreateCloudResourceCommand;
import com.infraoptix.infraoptix.application.port.in.result.CloudResourceResult;
import com.infraoptix.infraoptix.domain.model.aggregate.CloudResource;

@Service
public class CreateCloudResourceService implements com.infraoptix.infraoptix.application.port.in.usecase.CreateCloudResourceUseCase {
    @Override
    public CloudResourceResult execute(
            CreateCloudResourceCommand command) {

        CloudResource cloudResource =
                CloudResource.create(
                        command.resourceId(),
                        command.resourceName(),
                        command.resourceType(),
                        command.monthlyCost()
                );

        return new CloudResourceResult(
                cloudResource.getResourceId(),
                cloudResource.getResourceName(),
                cloudResource.getResourceType(),
                cloudResource.getStatus(),
                cloudResource.getMonthlyCost()
        );
    }
}
