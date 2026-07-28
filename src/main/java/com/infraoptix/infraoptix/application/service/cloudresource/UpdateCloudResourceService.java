package com.infraoptix.infraoptix.application.service.cloudresource;

import org.springframework.stereotype.Service;

import com.infraoptix.infraoptix.application.port.in.command.cloudresource.UpdateCloudResourceCommand;
import com.infraoptix.infraoptix.application.port.in.result.cloudresource.CloudResourceResult;
import com.infraoptix.infraoptix.application.port.in.usecase.cloudresource.UpdateCloudResourceUseCase;
import com.infraoptix.infraoptix.application.port.out.CloudResourceRepositoryPort;
import com.infraoptix.infraoptix.domain.model.aggregate.CloudResource;
import com.infraoptix.infraoptix.domain.model.exception.ResourceNotFoundException;

@Service
public class UpdateCloudResourceService implements UpdateCloudResourceUseCase {

    private final CloudResourceRepositoryPort repository;

    public UpdateCloudResourceService(CloudResourceRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public CloudResourceResult execute(UpdateCloudResourceCommand command) {

        CloudResource existingResource = repository.findById(command.id());

        if (existingResource == null) {
            throw new ResourceNotFoundException(
                    "Cloud Resource with id " + command.id() + " not found");
        }

        CloudResource updatedResource = CloudResource.reconstruct(
                existingResource.getId(),
                existingResource.getResourceId(),
                command.resourceName(),
                command.resourceType(),
                existingResource.getStatus(),
                command.monthlyCost()
        );

        repository.save(updatedResource);

        return new CloudResourceResult(
                updatedResource.getResourceId(),
                updatedResource.getResourceName(),
                updatedResource.getResourceType(),
                updatedResource.getStatus(),
                updatedResource.getMonthlyCost()
        );
    }
}