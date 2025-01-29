package com.example.stable_management.stbl_backend.services.implementations;

import com.example.stable_management.stbl_backend.entities.Tenant;
import com.example.stable_management.stbl_backend.exceptions.DtoValidationException;
import com.example.stable_management.stbl_backend.exceptions.ResourceNotFoundException;
import com.example.stable_management.stbl_backend.repositories.TenantRepository;
import com.example.stable_management.stbl_backend.services.interfaces.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;

    @Autowired
    public TenantServiceImpl(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    @Override
    public Tenant getTenantById(Long id) {
        return tenantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Tenant found with id " + id));
    }

    @Override
    public Tenant createTenant(Tenant tenant) {;
        validate(tenant);
        return tenantRepository.save(tenant);
    }

    @Override
    public Tenant getTenantByName(String tenant) {
        return tenantRepository.findByName(tenant);
    }

    @Override
    public void updateTenant(Tenant tenant) {
        tenantRepository.save(tenant);
    }

    @Override
    public void validate(Tenant tenant) {
        if(tenant.getName() == null || tenant.getName().isEmpty())
            throw new DtoValidationException("name must not be null or empty");

        if(getTenantByName(tenant.getName()) != null)
            throw new DtoValidationException("name already taken");
    }
}
