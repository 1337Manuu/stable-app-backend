package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.entities.Tenant;
import com.example.stable_management.stbl_backend.services.TenantService;
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
    public ResponseEntity<List<Tenant>> getAllTenants() {
        List<Tenant> tenantDtoList = tenantService.getAllTenants();
        return new ResponseEntity<>(tenantDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tenant> getTenantById(@PathVariable Long id) {
        return new ResponseEntity<>(tenantService.getTenantById(id), HttpStatus.OK);
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<Tenant> getTenantByName(@PathVariable String name) {
        return new ResponseEntity<>(tenantService.getTenantByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tenant> createTenant(@RequestBody Tenant tenant) {
        return new ResponseEntity<>(tenantService.createTenant(tenant), HttpStatus.CREATED);
    }
}
