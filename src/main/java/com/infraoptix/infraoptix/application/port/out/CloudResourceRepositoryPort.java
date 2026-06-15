package com.infraoptix.infraoptix.application.port.out;

import com.infraoptix.infraoptix.domain.model.aggregate.CloudResource;

public interface CloudResourceRepositoryPort {
    CloudResource save(CloudResource cloudResource);
    CloudResource findById(Long id);
}
