package com.infraoptix.infraoptix.infrastructure.persistence.jpa.adapter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.infraoptix.infraoptix.application.port.out.CloudResourceRepositoryPort;
import com.infraoptix.infraoptix.domain.model.aggregate.CloudResource;
import com.infraoptix.infraoptix.domain.model.exception.ResourceNotFoundException;
import com.infraoptix.infraoptix.infrastructure.persistence.jpa.entity.CloudResourceEntity;
import com.infraoptix.infraoptix.infrastructure.persistence.jpa.repository.CloudResourceJpaRepository;
import com.infraoptix.infraoptix.infrastructure.persistence.mapper.CloudResourceMapper;

@Component
public class CloudResourceAdapter implements CloudResourceRepositoryPort {

    private final CloudResourceJpaRepository repository;
    private final CloudResourceMapper mapper;

    public CloudResourceAdapter(
            CloudResourceJpaRepository repository,
            CloudResourceMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CloudResource save(CloudResource cloudResource) {

        CloudResourceEntity entity = mapper.toEntity(cloudResource);

        CloudResourceEntity saved = repository.save(entity);

        return mapper.toDomain(saved);
    }

    @Override
    public CloudResource findById(Long id) {
    CloudResourceEntity entity =
            repository.findById(id)
                    .orElseThrow(() ->
                            new ResourceNotFoundException(
                                    "Cloud Resource with id " + id + " not found"));

    return mapper.toDomain(entity);
    }

    @Override
    public List<CloudResource> findAll() {
        Iterable<CloudResourceEntity> entities = repository.findAll();

        // Assuming you want to return the first entity for demonstration purposes
        CloudResourceEntity entity = entities.iterator().hasNext() ? entities.iterator().next() : null;

        if (entity == null) {
            throw new RuntimeException("No CloudResources found");
        }

        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    
            }
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}