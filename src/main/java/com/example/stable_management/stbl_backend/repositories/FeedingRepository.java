package com.example.stable_management.stbl_backend.repositories;

import com.example.stable_management.stbl_backend.entities.Feeding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedingRepository extends JpaRepository<Feeding, Long> {
}
