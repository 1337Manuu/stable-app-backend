package com.example.stable_management.stbl_backend.services;

import com.example.stable_management.stbl_backend.dtos.tenant_dto.TenantDto;
import com.example.stable_management.stbl_backend.entities.Tenant;
import com.example.stable_management.stbl_backend.repositories.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TenantService {

    private final TenantRepository tenantRepository;

    @Autowired
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    public List<TenantDto> getAllTenants() {
        return tenantRepository.findAll().
                stream()
                .map(TenantDto::getDto)
                .collect(Collectors.toList());
    }

    public TenantDto getTenantById(Long id) {
        return tenantRepository.findById(id)
                .map(TenantDto::getDto).orElse(null);
    }

    public TenantDto createTenant(TenantDto tenantDto) {
        Tenant tenant = new Tenant();
        tenant.setName(tenantDto.name());
        tenant.setPhone(tenantDto.phone());
        tenantRepository.save(tenant);
        return TenantDto.getDto(tenant);
    }

}
