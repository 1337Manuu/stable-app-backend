package com.example.stable_management.stbl_backend.repositories;

import com.example.stable_management.stbl_backend.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {

    Tenant findByName(String tenant);
}