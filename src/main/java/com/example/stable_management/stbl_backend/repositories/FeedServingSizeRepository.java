package com.example.stable_management.stbl_backend.repositories;

import com.example.stable_management.stbl_backend.entities.FeedServingSize;
import com.example.stable_management.stbl_backend.entities.Horse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedServingSizeRepository extends JpaRepository<FeedServingSize, Long> {
}
