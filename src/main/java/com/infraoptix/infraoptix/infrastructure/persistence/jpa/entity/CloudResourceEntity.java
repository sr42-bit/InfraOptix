package com.infraoptix.infraoptix.infrastructure.persistence.jpa.entity;

import java.math.BigDecimal;

import com.infraoptix.infraoptix.domain.model.enums.ResourceStatus;
import com.infraoptix.infraoptix.domain.model.enums.ResourceType;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cloud_resources")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CloudResourceEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "resource_id", nullable = false, unique = true)
    private String resourceId;

    @Column(name = "resource_name", nullable = false)
    private String resourceName;

    @Enumerated(EnumType.STRING)
    @Column(name = "resource_type", nullable = false)
    private ResourceType resourceType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ResourceStatus status;

    @Column(name = "monthly_cost", precision = 10, scale = 2)
    private BigDecimal monthlyCost;
}
