package com.example.stable_management.stbl_backend.services.interfaces;

import com.example.stable_management.stbl_backend.entities.Tenant;

import java.util.List;

public interface TenantService {
    List<Tenant> getAllTenants();

    Tenant getTenantById(Long id);

    Tenant createTenant(Tenant tenant);

    Tenant getTenantByName(String tenant);

    void updateTenant(Tenant tenant);
}
