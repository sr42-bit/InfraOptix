package com.infraoptix.infraoptix.infrastructure.web.controller;

import com.infraoptix.infraoptix.application.port.in.command.CreateCloudResourceCommand;
import com.infraoptix.infraoptix.application.port.in.result.CloudResourceResult;
import com.infraoptix.infraoptix.application.port.in.usecase.CreateCloudResourceUseCase;
import com.infraoptix.infraoptix.domain.model.enums.ResourceType;
import com.infraoptix.infraoptix.infrastructure.web.dto.request.CreateCloudResourceRequest;
import com.infraoptix.infraoptix.infrastructure.web.dto.response.CloudResourceResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resources")
public class CloudResourceController {

    private final CreateCloudResourceUseCase createCloudResourceUseCase;

    public CloudResourceController(
            CreateCloudResourceUseCase createCloudResourceUseCase) {
        this.createCloudResourceUseCase = createCloudResourceUseCase;
    }

    @PostMapping
    public CloudResourceResponse create(
            @RequestBody CreateCloudResourceRequest request) {

        CreateCloudResourceCommand command =
                new CreateCloudResourceCommand(
                        request.resourceId(),
                        request.resourceName(),
                        ResourceType.valueOf(
                                request.resourceType().toUpperCase()),
                        request.monthlyCost()
                );

        CloudResourceResult result =
                createCloudResourceUseCase.execute(command);

        return new CloudResourceResponse(
                result.resourceId(),
                result.resourceName(),
                result.resourceType().name(),
                result.status().name(),
                result.monthlyCost()
        );
    }
}
