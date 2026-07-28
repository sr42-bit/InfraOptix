package com.infraoptix.infraoptix.application.port.in.usecase.cloudresource;

import com.infraoptix.infraoptix.application.port.in.command.cloudresource.UpdateCloudResourceCommand;
import com.infraoptix.infraoptix.application.port.in.result.cloudresource.CloudResourceResult;

public interface UpdateCloudResourceUseCase {

    CloudResourceResult execute(UpdateCloudResourceCommand command);
}
