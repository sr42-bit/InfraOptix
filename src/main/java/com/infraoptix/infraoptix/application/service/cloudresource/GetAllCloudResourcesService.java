package com.infraoptix.infraoptix.application.service.cloudresource;

import java.util.List;

import org.springframework.stereotype.Service;

import com.infraoptix.infraoptix.application.port.in.result.cloudresource.CloudResourceResult;
import com.infraoptix.infraoptix.application.port.in.usecase.cloudresource.GetAllCloudResourcesUseCase;
import com.infraoptix.infraoptix.application.port.out.CloudResourceRepositoryPort;

@Service
public class GetAllCloudResourcesService
        implements GetAllCloudResourcesUseCase {

    private final CloudResourceRepositoryPort repository;

    public GetAllCloudResourcesService(
            CloudResourceRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<CloudResourceResult> execute() {

        return repository.findAll()
                .stream()
                .map(resource -> new CloudResourceResult(
                        resource.getResourceId(),
                        resource.getResourceName(),
                        resource.getResourceType(),
                        resource.getStatus(),
                        resource.getMonthlyCost()
                ))
                .toList();
    }
}