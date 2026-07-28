package com.infraoptix.infraoptix.application.port.in.usecase.cloudresource;

import java.util.List;

import com.infraoptix.infraoptix.application.port.in.result.cloudresource.CloudResourceResult;

public interface GetAllCloudResourcesUseCase {
     List<CloudResourceResult> execute();
}
