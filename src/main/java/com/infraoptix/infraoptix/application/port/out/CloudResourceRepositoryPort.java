package com.infraoptix.infraoptix.application.port.out;

import java.util.List;

import com.infraoptix.infraoptix.domain.model.aggregate.CloudResource;
public interface CloudResourceRepositoryPort {
    CloudResource save(CloudResource cloudResource);
    CloudResource findById(Long id);
    List<CloudResource> findAll();
    void deleteById(Long id);
}
