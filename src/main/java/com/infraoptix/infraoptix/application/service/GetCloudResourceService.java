package com.infraoptix.infraoptix.application.service;

import org.springframework.stereotype.Service;

import com.infraoptix.infraoptix.application.port.in.result.CloudResourceResult;
import com.infraoptix.infraoptix.application.port.in.usecase.GetCloudResourceUsecase;
import com.infraoptix.infraoptix.application.port.out.CloudResourceRepositoryPort;
import com.infraoptix.infraoptix.domain.model.aggregate.CloudResource;

@Service
public class GetCloudResourceService
        implements GetCloudResourceUsecase {

    private final CloudResourceRepositoryPort repository;

    public GetCloudResourceService(
            CloudResourceRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public CloudResourceResult execute(Long id) {

        CloudResource cloudResource =
                repository.findById(id);

        return new CloudResourceResult(
                cloudResource.getResourceId(),
                cloudResource.getResourceName(),
                cloudResource.getResourceType(),
                cloudResource.getStatus(),
                cloudResource.getMonthlyCost()
        );
    }
}