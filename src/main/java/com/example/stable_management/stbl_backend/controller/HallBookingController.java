package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.dtos.hall_booking_dto.HallBookingDto;
import com.example.stable_management.stbl_backend.entities.HallBooking;
import com.example.stable_management.stbl_backend.services.HallBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hall-bookings")
public class HallBookingController {

    HallBookingService hallBookingService;

    @Autowired
    public HallBookingController(HallBookingService hallBookingService) {
        this.hallBookingService = hallBookingService;
    }

    @GetMapping
    public ResponseEntity<List<HallBookingDto>> getAllHallBookings() {
        List<HallBookingDto> hallBookings = hallBookingService.getAllHallBookings();
        return new ResponseEntity<>(hallBookings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HallBookingDto> getHallBookingById(@PathVariable Long id) {
        HallBookingDto hallBooking = hallBookingService.getHallBookingById(id);
        return new ResponseEntity<>(hallBooking, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HallBookingDto> createHallBooking(@RequestBody HallBookingDto hallBookingDto) {
        HallBookingDto createdHallBooking = hallBookingService.createHallBooking(hallBookingDto);
        return new ResponseEntity<>(createdHallBooking, HttpStatus.CREATED);
    }

    @PutMapping("/{hallBookingId}/tenants/{tenantId}")
    public ResponseEntity<HallBookingDto> assignHallBookingToTenant(@PathVariable Long hallBookingId, @PathVariable Long tenantId) {
        HallBookingDto assignedHallBooking = hallBookingService.assignHallBookingToTenant(hallBookingId, tenantId);
        return new ResponseEntity<>(assignedHallBooking, HttpStatus.OK);
    }
}
