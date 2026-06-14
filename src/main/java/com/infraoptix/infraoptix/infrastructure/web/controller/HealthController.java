package com.infraoptix.infraoptix.infrastructure.web.controller;

import com.infraoptix.infraoptix.application.port.in.command.GetHealthStatusCommand;
import com.infraoptix.infraoptix.application.port.in.result.GetHealthStatusResult;
import com.infraoptix.infraoptix.application.port.in.usecase.GetHealthStatusUseCase;
import com.infraoptix.infraoptix.infrastructure.web.dto.response.HealthStatusResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    private final GetHealthStatusUseCase getHealthStatusUseCase;

    public HealthController(GetHealthStatusUseCase getHealthStatusUseCase) {
        this.getHealthStatusUseCase = getHealthStatusUseCase;
    }

    @GetMapping("/api/health")
    public HealthStatusResponse health() {

        GetHealthStatusResult result =
                getHealthStatusUseCase.execute(
                        new GetHealthStatusCommand()
                );

        return new HealthStatusResponse(
                result.status(),
                result.service()
        );
    }
    
}
