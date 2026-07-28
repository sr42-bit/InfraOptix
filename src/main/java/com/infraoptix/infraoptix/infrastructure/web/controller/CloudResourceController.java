package com.infraoptix.infraoptix.infrastructure.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.infraoptix.infraoptix.application.port.in.command.cloudresource.CreateCloudResourceCommand;
import com.infraoptix.infraoptix.application.port.in.command.cloudresource.DeleteCloudResourceCommand;
import com.infraoptix.infraoptix.application.port.in.command.cloudresource.UpdateCloudResourceCommand;
import com.infraoptix.infraoptix.application.port.in.result.cloudresource.CloudResourceResult;
import com.infraoptix.infraoptix.application.port.in.usecase.cloudresource.CreateCloudResourceUseCase;
import com.infraoptix.infraoptix.application.port.in.usecase.cloudresource.DeleteCloudResourceUseCase;
import com.infraoptix.infraoptix.application.port.in.usecase.cloudresource.GetAllCloudResourcesUseCase;
import com.infraoptix.infraoptix.application.port.in.usecase.cloudresource.GetCloudResourceUseCase;
import com.infraoptix.infraoptix.application.port.in.usecase.cloudresource.UpdateCloudResourceUseCase;
import com.infraoptix.infraoptix.domain.model.enums.ResourceType;
import com.infraoptix.infraoptix.infrastructure.web.dto.request.CreateCloudResourceRequest;
import com.infraoptix.infraoptix.infrastructure.web.dto.request.UpdateCloudResourceRequest;
import com.infraoptix.infraoptix.infrastructure.web.dto.response.CloudResourceResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/resources")
@Tag(
    name = "Cloud Resources",
    description = "Operations for managing cloud resources"
)
public class CloudResourceController {

    private final CreateCloudResourceUseCase createCloudResourceUseCase;
    private final GetCloudResourceUseCase getCloudResourceUsecase;
    private final GetAllCloudResourcesUseCase getAllCloudResourcesUseCase;
    private final UpdateCloudResourceUseCase  updateCloudResourceUsecase;
    private final DeleteCloudResourceUseCase deleteCloudResourceUsecase;

    public CloudResourceController(
            CreateCloudResourceUseCase createCloudResourceUseCase,
            GetCloudResourceUseCase getCloudResourceUsecase,
            GetAllCloudResourcesUseCase getAllCloudResourcesUseCase,
            UpdateCloudResourceUseCase  updateCloudResourceUsecase,
            DeleteCloudResourceUseCase deleteCloudResourceUsecase) {

        this.createCloudResourceUseCase = createCloudResourceUseCase;
        this.getCloudResourceUsecase = getCloudResourceUsecase;
        this.getAllCloudResourcesUseCase = getAllCloudResourcesUseCase;
        this.updateCloudResourceUsecase = updateCloudResourceUsecase;
        this.deleteCloudResourceUsecase = deleteCloudResourceUsecase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Create Cloud Resource",
            description = "Creates a new cloud resource."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cloud resource created successfully"),
            @ApiResponse(responseCode = "400", description = "Validation failed")
    })
    public CloudResourceResponse create(
            @Valid @RequestBody CreateCloudResourceRequest request) {

        CreateCloudResourceCommand command =
        new CreateCloudResourceCommand(
                request.resourceId(),
                request.resourceName(),
                ResourceType.valueOf(request.resourceType().toUpperCase()),
                request.monthlyCost()
        );

        CloudResourceResult result = createCloudResourceUseCase.execute(command);

        return toResponse(result);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get Cloud Resource by ID",
            description = "Returns a cloud resource by its ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cloud resource found"),
            @ApiResponse(responseCode = "404", description = "Cloud resource not found")
    })
    public CloudResourceResponse getById(
            @Parameter(description = "Cloud Resource ID")
            @PathVariable Long id) {

        CloudResourceResult result = getCloudResourceUsecase.execute(id);

        return toResponse(result);
    }

    @GetMapping
    @Operation(
            summary = "Get All Cloud Resources",
            description = "Returns all cloud resources."
    )
    @ApiResponse(responseCode = "200", description = "Resources retrieved successfully")
    public List<CloudResourceResponse> getAll() {

        return getAllCloudResourcesUseCase.execute()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update Cloud Resource",
            description = "Updates an existing cloud resource."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cloud resource updated successfully"),
            @ApiResponse(responseCode = "400", description = "Validation failed"),
            @ApiResponse(responseCode = "404", description = "Cloud resource not found")
    })
    public CloudResourceResponse update(
            @Parameter(description = "Cloud Resource ID")
            @PathVariable Long id,
            @Valid @RequestBody UpdateCloudResourceRequest request) {

        UpdateCloudResourceCommand command =
        new UpdateCloudResourceCommand(
                id,
                request.resourceName(),
                ResourceType.valueOf(request.resourceType().toUpperCase()),
                null,
                request.monthlyCost()
        );

        CloudResourceResult result = updateCloudResourceUsecase.execute(command);

        return toResponse(result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete Cloud Resource",
            description = "Deletes a cloud resource by its ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Cloud resource deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Cloud resource not found")
    })
    public void delete(
            @Parameter(description = "Cloud Resource ID")
            @PathVariable Long id) {

        deleteCloudResourceUsecase.execute(
                new DeleteCloudResourceCommand(id)
        );
    }

    private CloudResourceResponse toResponse(CloudResourceResult result) {

        return new CloudResourceResponse(
                result.resourceId(),
                result.resourceName(),
                result.resourceType().name(),
                result.status().name(),
                result.monthlyCost()
        );
    }
}