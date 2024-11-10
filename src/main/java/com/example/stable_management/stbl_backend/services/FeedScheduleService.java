package com.example.stable_management.stbl_backend.services;

import com.example.stable_management.stbl_backend.dtos.feed_schedule_dto.FeedScheduleDto;
import com.example.stable_management.stbl_backend.entities.FeedSchedule;
import com.example.stable_management.stbl_backend.repositories.FeedScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedScheduleService {

    private final FeedScheduleRepository feedScheduleRepository;

    public FeedScheduleService(FeedScheduleRepository feedScheduleRepository) {
        this.feedScheduleRepository = feedScheduleRepository;
    }

    public List<FeedScheduleDto> getAllFeedSchedules() {
        return feedScheduleRepository.findAll().stream()
                .map(FeedScheduleDto::getDto)
                .collect(Collectors.toList());
    }

    public FeedScheduleDto getFeedScheduleById(Long id) {
        return FeedScheduleDto.getDto(feedScheduleRepository.findById(id).orElse(null));
    }

    public FeedScheduleDto createFeedSchedule(FeedScheduleDto feedScheduleDto) {
        FeedSchedule feedSchedule = new FeedSchedule();
        feedSchedule.setNote(feedScheduleDto.note());
        feedScheduleRepository.save(feedSchedule);
        return FeedScheduleDto.getDto(feedSchedule);
    }
}
