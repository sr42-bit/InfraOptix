package com.infraoptix.infraoptix.application.port.in.usecase;

import com.infraoptix.infraoptix.application.port.in.command.GetHealthStatusCommand;
import com.infraoptix.infraoptix.application.port.in.result.GetHealthStatusResult;

public interface GetHealthStatusUseCase {
    GetHealthStatusResult execute(GetHealthStatusCommand command);
}
