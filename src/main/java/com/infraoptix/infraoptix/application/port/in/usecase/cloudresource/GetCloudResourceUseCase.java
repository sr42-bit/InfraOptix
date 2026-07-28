package com.infraoptix.infraoptix.application.port.in.usecase.cloudresource;

import com.infraoptix.infraoptix.application.port.in.result.cloudresource.CloudResourceResult;

public interface GetCloudResourceUseCase {
    CloudResourceResult execute(Long id);
}