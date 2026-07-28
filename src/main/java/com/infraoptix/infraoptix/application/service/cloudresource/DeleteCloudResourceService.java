package com.infraoptix.infraoptix.application.service.cloudresource;

import org.springframework.stereotype.Service;

import com.infraoptix.infraoptix.application.port.in.command.cloudresource.DeleteCloudResourceCommand;
import com.infraoptix.infraoptix.application.port.in.usecase.cloudresource.DeleteCloudResourceUseCase;
import com.infraoptix.infraoptix.application.port.out.CloudResourceRepositoryPort;
import com.infraoptix.infraoptix.domain.model.aggregate.CloudResource;
import com.infraoptix.infraoptix.domain.model.exception.ResourceNotFoundException;

@Service
public class DeleteCloudResourceService
        implements DeleteCloudResourceUseCase {

    private final CloudResourceRepositoryPort cloudResourceRepositoryPort;

    public DeleteCloudResourceService(
            CloudResourceRepositoryPort cloudResourceRepositoryPort) {
        this.cloudResourceRepositoryPort = cloudResourceRepositoryPort;
    }

    @Override
    public void execute(DeleteCloudResourceCommand command) {

        CloudResource cloudResource =
                cloudResourceRepositoryPort.findById(command.id());

        if (cloudResource == null) {
            throw new ResourceNotFoundException(
                    "Cloud Resource with id " + command.id() + " not found");
        }

        cloudResourceRepositoryPort.deleteById(command.id());
    }
}