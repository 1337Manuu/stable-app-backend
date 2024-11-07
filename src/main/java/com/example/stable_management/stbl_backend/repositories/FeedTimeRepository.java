package com.example.stable_management.stbl_backend.repositories;

import com.example.stable_management.stbl_backend.entities.FeedTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedTimeRepository extends JpaRepository<FeedTime, Long> {
}
