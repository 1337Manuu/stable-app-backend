package com.example.stable_management.stbl_backend.services;

import com.example.stable_management.stbl_backend.dtos.hall_booking_dto.HallBookingDto;
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

    public List<HallBookingDto> getAllHallBookings() {
        return hallBookingRepository.findAll()
                .stream()
                .map(HallBookingDto::getDto)
                .collect(Collectors.toList());
    }

    public HallBookingDto getHallBookingById(Long id) {
        return hallBookingRepository.findById(id)
                .map(HallBookingDto::getDto)
                .orElse(null);
    }

    public HallBookingDto createHallBooking(HallBookingDto hallBookingDto) {
        HallBooking hallBooking = new HallBooking();
        hallBooking.setStartTime(hallBookingDto.startTime());
        hallBooking.setEndTime(hallBookingDto.endTime());
        HallBooking savedHallBooking = hallBookingRepository.save(hallBooking);
        return HallBookingDto.getDto(savedHallBooking);
    }

    public HallBookingDto assignHallBookingToTenant(Long hallBookingId, Long tenantId) {
        if (hallBookingRepository.findById(hallBookingId).isEmpty() || tenantRepository.findById(tenantId).isEmpty()){
            throw new NoSuchElementException("No HallBooking or Tenant found.");
        }
        HallBooking hallBooking = hallBookingRepository.findById(hallBookingId).get();
        Tenant tenant = tenantRepository.findById(tenantId).get();
        hallBooking.assignTenant(tenant);
        hallBookingRepository.save(hallBooking);
        return HallBookingDto.getDto(hallBooking);
    }
}
