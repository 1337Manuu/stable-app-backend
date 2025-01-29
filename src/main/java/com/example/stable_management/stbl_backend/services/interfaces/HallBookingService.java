package com.example.stable_management.stbl_backend.services.interfaces;

import com.example.stable_management.stbl_backend.entities.HallBooking;

import java.util.List;

public interface HallBookingService {
    List<HallBooking> getAllHallBookings();

    HallBooking getHallBookingById(Long id);

    HallBooking createHallBooking(HallBooking hallBooking);

    HallBooking assignHallBookingToTenant(Long hallBookingId, Long tenantId);
}
