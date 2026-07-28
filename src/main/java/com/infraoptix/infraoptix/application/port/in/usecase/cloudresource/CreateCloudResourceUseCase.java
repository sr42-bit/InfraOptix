package com.infraoptix.infraoptix.application.port.in.usecase.cloudresource;

import com.infraoptix.infraoptix.application.port.in.command.cloudresource.CreateCloudResourceCommand;
import com.infraoptix.infraoptix.application.port.in.result.cloudresource.CloudResourceResult;

public interface CreateCloudResourceUseCase {
    CloudResourceResult execute(CreateCloudResourceCommand command);
}
