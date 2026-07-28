package com.infraoptix.infraoptix.application.service.cloudresource;

import org.springframework.stereotype.Service;

import com.infraoptix.infraoptix.application.port.in.command.cloudresource.CreateCloudResourceCommand;
import com.infraoptix.infraoptix.application.port.in.result.cloudresource.CloudResourceResult;
import com.infraoptix.infraoptix.application.port.in.usecase.cloudresource.CreateCloudResourceUseCase;
import com.infraoptix.infraoptix.application.port.out.CloudResourceRepositoryPort;
import com.infraoptix.infraoptix.domain.model.aggregate.CloudResource;

@Service

public class CreateCloudResourceService
        implements CreateCloudResourceUseCase {

    private final CloudResourceRepositoryPort repository;

    public CreateCloudResourceService(CloudResourceRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public CloudResourceResult execute(CreateCloudResourceCommand command) {

        CloudResource cloudResource =
                CloudResource.create(
                        command.resourceId(),
                        command.resourceName(),
                        command.resourceType(),
                        command.monthlyCost()
                );

        cloudResource = repository.save(cloudResource);

        return new CloudResourceResult(
                cloudResource.getResourceId(),
                cloudResource.getResourceName(),
                cloudResource.getResourceType(),
                cloudResource.getStatus(),
                cloudResource.getMonthlyCost()
        );
    }
}

