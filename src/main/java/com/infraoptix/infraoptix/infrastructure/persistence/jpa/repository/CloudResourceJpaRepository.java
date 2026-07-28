package com.infraoptix.infraoptix.infrastructure.persistence.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infraoptix.infraoptix.infrastructure.persistence.jpa.entity.CloudResourceEntity;

public interface CloudResourceJpaRepository extends JpaRepository<CloudResourceEntity, Long> {
    
}
