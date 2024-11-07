package com.example.stable_management.stbl_backend.services;

import com.example.stable_management.stbl_backend.dto.TenantRequestDto;
import com.example.stable_management.stbl_backend.entities.Horse;
import com.example.stable_management.stbl_backend.entities.Tenant;
import com.example.stable_management.stbl_backend.repositories.HorseRepository;
import com.example.stable_management.stbl_backend.repositories.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TenantService {

    private final TenantRepository tenantRepository;
    private final HorseRepository horseRepository;

    @Autowired
    public TenantService(TenantRepository tenantRepository, HorseRepository horseRepository) {
        this.tenantRepository = tenantRepository;
        this.horseRepository = horseRepository;
    }

    public List<TenantRequestDto> getAllTenants() {
        return tenantRepository.findAll().
                stream()
                .map(tenant -> new TenantRequestDto(
                        tenant.getName(),
                        tenant.getPhone(),
                        tenant.getHorses()
                                .stream()
                                .map(Horse::getName)
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    public TenantRequestDto getTenantById(Long id) {
        return tenantRepository.findById(id)
                .map(tenant -> new TenantRequestDto(
                        tenant.getName(),
                        tenant.getPhone(),
                        tenant.getHorses()
                                .stream()
                                .map(Horse::getName)
                                .collect(Collectors.toList())
                )).orElse(null);
    }

    public Tenant createTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

}
