package com.example.stable_management.stbl_backend.services;

import com.example.stable_management.stbl_backend.entities.HallBooking;
import com.example.stable_management.stbl_backend.entities.Tenant;
import com.example.stable_management.stbl_backend.repositories.HallBookingRepository;
import com.example.stable_management.stbl_backend.repositories.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HallBookingService {

    HallBookingRepository hallBookingRepository;
    TenantRepository tenantRepository;

    public HallBookingService(HallBookingRepository hallBookingRepository, TenantRepository tenantRepository) {
        this.hallBookingRepository = hallBookingRepository;
        this.tenantRepository = tenantRepository;
    }

    public List<HallBooking> getAllHallBookings() {
        return hallBookingRepository.findAll();
    }

    public HallBooking getHallBookingById(Long id) {
        return hallBookingRepository.findById(id).orElse(null);
    }

    public HallBooking createHallBooking(HallBooking hallBooking) {
        return hallBookingRepository.save(hallBooking);
    }

    public HallBooking assignHallBookingToTenant(Long hallBookingId, Long tenantId) {
        if (hallBookingRepository.findById(hallBookingId).isEmpty() || tenantRepository.findById(tenantId).isEmpty()){
            throw new NoSuchElementException("No HallBooking or Tenant found.");
        }
        HallBooking hallBooking = hallBookingRepository.findById(hallBookingId).get();
        Tenant tenant = tenantRepository.findById(tenantId).get();
        hallBooking.assignTenant(tenant);
        return hallBookingRepository.save(hallBooking);
    }
}
