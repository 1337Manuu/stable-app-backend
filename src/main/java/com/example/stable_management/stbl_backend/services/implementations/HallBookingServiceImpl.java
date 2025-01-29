package com.example.stable_management.stbl_backend.services.implementations;

import com.example.stable_management.stbl_backend.entities.HallBooking;
import com.example.stable_management.stbl_backend.entities.Tenant;
import com.example.stable_management.stbl_backend.repositories.HallBookingRepository;
import com.example.stable_management.stbl_backend.repositories.TenantRepository;
import com.example.stable_management.stbl_backend.services.interfaces.HallBookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HallBookingServiceImpl implements HallBookingService {

    HallBookingRepository hallBookingRepository;
    TenantRepository tenantRepository;

    public HallBookingServiceImpl(HallBookingRepository hallBookingRepository, TenantRepository tenantRepository) {
        this.hallBookingRepository = hallBookingRepository;
        this.tenantRepository = tenantRepository;
    }

    @Override
    public List<HallBooking> getAllHallBookings() {
        return hallBookingRepository.findAll();
    }

    @Override
    public HallBooking getHallBookingById(Long id) {
        return hallBookingRepository.findById(id).orElse(null);
    }

    @Override
    public HallBooking createHallBooking(HallBooking hallBooking) {
        return hallBookingRepository.save(hallBooking);
    }

    @Override
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
