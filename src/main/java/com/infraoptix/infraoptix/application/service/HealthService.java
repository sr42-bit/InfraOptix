package com.infraoptix.infraoptix.application.service;

import com.infraoptix.infraoptix.application.port.in.command.GetHealthStatusCommand;
import com.infraoptix.infraoptix.application.port.in.result.GetHealthStatusResult;
import com.infraoptix.infraoptix.application.port.in.usecase.GetHealthStatusUseCase;

import org.springframework.stereotype.Service;

@Service
public class HealthService implements GetHealthStatusUseCase {
    @Override
    public GetHealthStatusResult execute(GetHealthStatusCommand command) {
        
        return new GetHealthStatusResult("InfraOptix", "UP");
    }    
}
