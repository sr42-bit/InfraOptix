package com.infraoptix.infraoptix.application.service.cloudresource;

import org.springframework.stereotype.Service;

import com.infraoptix.infraoptix.application.port.in.result.cloudresource.CloudResourceResult;
import com.infraoptix.infraoptix.application.port.in.usecase.cloudresource.GetCloudResourceUseCase;
import com.infraoptix.infraoptix.application.port.out.CloudResourceRepositoryPort;
import com.infraoptix.infraoptix.domain.model.aggregate.CloudResource;
import com.infraoptix.infraoptix.domain.model.exception.ResourceNotFoundException;

@Service
public class GetCloudResourceService
        implements GetCloudResourceUseCase {

    private final CloudResourceRepositoryPort repository;

    public GetCloudResourceService(
            CloudResourceRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public CloudResourceResult execute(Long id) {

        CloudResource cloudResource = repository.findById(id);

        if (cloudResource == null) {
    System.out.println("ResourceNotFoundException thrown");
    throw new ResourceNotFoundException(
            "Cloud Resource with id " + id + " not found");
}

        return new CloudResourceResult(
                cloudResource.getResourceId(),
                cloudResource.getResourceName(),
                cloudResource.getResourceType(),
                cloudResource.getStatus(),
                cloudResource.getMonthlyCost()
        );
    }
}