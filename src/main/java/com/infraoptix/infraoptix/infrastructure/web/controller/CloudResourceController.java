package com.infraoptix.infraoptix.infrastructure.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.infraoptix.infraoptix.application.port.in.command.CreateCloudResourceCommand;
import com.infraoptix.infraoptix.application.port.in.result.CloudResourceResult;
import com.infraoptix.infraoptix.application.port.in.usecase.CreateCloudResourceUseCase;
import com.infraoptix.infraoptix.application.port.in.usecase.GetCloudResourceUsecase;
import com.infraoptix.infraoptix.domain.model.enums.ResourceType;
import com.infraoptix.infraoptix.infrastructure.web.dto.request.CreateCloudResourceRequest;
import com.infraoptix.infraoptix.infrastructure.web.dto.response.CloudResourceResponse;

@RestController
@RequestMapping("/api/resources")
public class CloudResourceController {

    private final CreateCloudResourceUseCase createCloudResourceUseCase;
    private final GetCloudResourceUsecase getCloudResourceUsecase;


    public CloudResourceController(
            CreateCloudResourceUseCase createCloudResourceUseCase,
            GetCloudResourceUsecase getCloudResourceUsecase) {

        this.createCloudResourceUseCase = createCloudResourceUseCase;
        this.getCloudResourceUsecase = getCloudResourceUsecase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CloudResourceResponse create(
            @RequestBody CreateCloudResourceRequest request) {

        CreateCloudResourceCommand command =
                new CreateCloudResourceCommand(
                        request.resourceId(),
                        request.resourceName(),
                        ResourceType.valueOf(
                                request.resourceType().toUpperCase()),
                        request.monthlyCost());

        CloudResourceResult result =
                createCloudResourceUseCase.execute(command);

        return new CloudResourceResponse(
                result.resourceId(),
                result.resourceName(),
                result.resourceType().name(),
                result.status().name(),
                result.monthlyCost());
    }

    @GetMapping("/{id}")
public CloudResourceResponse getById(
        @PathVariable Long id) {

    CloudResourceResult result =
            getCloudResourceUsecase.execute(id);

    return new CloudResourceResponse(
            result.resourceId(),
            result.resourceName(),
            result.resourceType().name(),
            result.status().name(),
            result.monthlyCost());
}
}