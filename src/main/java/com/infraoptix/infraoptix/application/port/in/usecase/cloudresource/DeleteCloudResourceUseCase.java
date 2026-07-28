package com.infraoptix.infraoptix.application.port.in.usecase.cloudresource;

import com.infraoptix.infraoptix.application.port.in.command.cloudresource.DeleteCloudResourceCommand;


public interface DeleteCloudResourceUseCase {
      
    void execute(DeleteCloudResourceCommand command);    
}
