package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.dtos.tenant_dto.TenantDto;
import com.example.stable_management.stbl_backend.entities.Tenant;
import com.example.stable_management.stbl_backend.services.TenantService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenants")
public class TenantController {

    private final TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping
    public ResponseEntity<List<TenantDto>> getAllTenants() {
        List<TenantDto> tenantDtoList = tenantService.getAllTenants();
        return new ResponseEntity<>(tenantDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TenantDto> getTenantById(@PathVariable Long id) {
        TenantDto tenantDto = tenantService.getTenantById(id);
        return new ResponseEntity<>(tenantDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TenantDto> createTenant(@RequestBody TenantDto tenantDto) {
        TenantDto createdTenantDto = tenantService.createTenant(tenantDto);
        return new ResponseEntity<>(createdTenantDto, HttpStatus.CREATED);
    }
}
