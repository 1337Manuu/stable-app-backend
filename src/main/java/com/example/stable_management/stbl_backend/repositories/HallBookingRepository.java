package com.example.stable_management.stbl_backend.repositories;

import com.example.stable_management.stbl_backend.entities.HallBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallBookingRepository extends JpaRepository<HallBooking, Integer> {
}
