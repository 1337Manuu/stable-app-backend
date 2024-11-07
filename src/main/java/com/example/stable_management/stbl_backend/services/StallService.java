package com.example.stable_management.stbl_backend.services;

import com.example.stable_management.stbl_backend.dto.StallRequestDto;
import com.example.stable_management.stbl_backend.entities.Stall;
import com.example.stable_management.stbl_backend.repositories.StallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StallService {

    private final StallRepository stallRepository;

    @Autowired
    public StallService(StallRepository stallRepository) {
        this.stallRepository = stallRepository;
    }

    public List<StallRequestDto> getAllStalls() {
        return stallRepository.findAll()
                .stream()
                .map(stall -> new StallRequestDto(
                        stall.getId()
                )).collect(Collectors.toList());
    }

    public StallRequestDto getStallById(Long id) {
        return stallRepository.findById(id)
                .map(stall -> new StallRequestDto(
                        stall.getId()
                ))
                .orElse(null);
    }

    public Stall createStall(Stall stall) {
        return stallRepository.save(stall);
    }
}

