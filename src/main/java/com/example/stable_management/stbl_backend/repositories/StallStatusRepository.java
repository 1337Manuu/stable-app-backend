package com.example.stable_management.stbl_backend.repositories;

import com.example.stable_management.stbl_backend.entities.StallStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StallStatusRepository extends JpaRepository<StallStatus, Integer> {
}
