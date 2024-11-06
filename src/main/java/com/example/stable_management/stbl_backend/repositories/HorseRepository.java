package com.example.stable_management.stbl_backend.repositories;

import com.example.stable_management.stbl_backend.entities.Horse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorseRepository extends JpaRepository<Horse, Integer> {
}
