package com.example.stable_management.stbl_backend.repositories;

import com.example.stable_management.stbl_backend.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Integer> {
}