package com.infraoptix.infraoptix.application.port.in.usecase;

import com.infraoptix.infraoptix.application.port.in.command.CreateCloudResourceCommand;
import com.infraoptix.infraoptix.application.port.in.result.CloudResourceResult;

public interface CreateCloudResourceUseCase {
    CloudResourceResult execute(CreateCloudResourceCommand command);
}
