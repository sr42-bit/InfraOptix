package com.infraoptix.infraoptix.application.port.in.result;

public record GetHealthStatusResult(
    String service,
    String status
) {}