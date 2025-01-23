package com.example.stable_management.stbl_backend.controller;

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
    public ResponseEntity<List<HallBooking>> getAllHallBookings() {
        return new ResponseEntity<>(hallBookingService.getAllHallBookings(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HallBooking> getHallBookingById(@PathVariable Long id) {
        return new ResponseEntity<>(hallBookingService.getHallBookingById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HallBooking> createHallBooking(@RequestBody HallBooking hallBooking) {
        return new ResponseEntity<>(hallBookingService.createHallBooking(hallBooking), HttpStatus.CREATED);
    }

    @PutMapping("/{hallBookingId}/tenants/{tenantId}")
    public ResponseEntity<HallBooking> assignHallBookingToTenant(@PathVariable Long hallBookingId, @PathVariable Long tenantId) {
        return new ResponseEntity<>(hallBookingService.assignHallBookingToTenant(hallBookingId, tenantId), HttpStatus.OK);
    }
}
