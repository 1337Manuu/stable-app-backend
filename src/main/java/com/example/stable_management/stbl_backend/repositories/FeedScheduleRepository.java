package com.example.stable_management.stbl_backend.repositories;

import com.example.stable_management.stbl_backend.entities.FeedSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedScheduleRepository extends JpaRepository<FeedSchedule, Integer> {
}
