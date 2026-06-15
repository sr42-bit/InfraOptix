package com.infraoptix.infraoptix.infrastructure.persistence.jpa.adapter;

import org.springframework.stereotype.Component;

import com.infraoptix.infraoptix.application.port.out.CloudResourceRepositoryPort;
import com.infraoptix.infraoptix.domain.model.aggregate.CloudResource;
import com.infraoptix.infraoptix.infrastructure.persistence.jpa.entity.CloudResourceEntity;
import com.infraoptix.infraoptix.infrastructure.persistence.jpa.repository.CloudResourceJpaRepository;
import com.infraoptix.infraoptix.infrastructure.persistence.mapper.CloudResourceMapper;

@Component
public class CloudResourcePersistenceAdapter
        implements CloudResourceRepositoryPort {

    private final CloudResourceJpaRepository repository;
    private final CloudResourceMapper mapper;

    public CloudResourcePersistenceAdapter(
            CloudResourceJpaRepository repository,
            CloudResourceMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CloudResource save(CloudResource cloudResource) {

        CloudResourceEntity entity =
                mapper.toEntity(cloudResource);

        CloudResourceEntity saved =
                repository.save(entity);

        return mapper.toDomain(saved);
    }

    @Override
    public CloudResource findById(Long id) {
        CloudResourceEntity entity =
                repository.findById(id)
                        .orElseThrow(() -> new RuntimeException("CloudResource not found with id: " + id));

        return mapper.toDomain(entity);
    }
}