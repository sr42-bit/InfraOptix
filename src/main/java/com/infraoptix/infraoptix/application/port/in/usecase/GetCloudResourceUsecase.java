package com.infraoptix.infraoptix.application.port.in.usecase;

import com.infraoptix.infraoptix.application.port.in.result.CloudResourceResult;

public interface GetCloudResourceUsecase {
    CloudResourceResult execute(Long id);
}