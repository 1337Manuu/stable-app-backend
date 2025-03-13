package com.example.stable_management.stbl_backend.services.implementations;

import com.example.stable_management.stbl_backend.dtos.FeedServingSizeDto;
import com.example.stable_management.stbl_backend.dtos.FeedTypeDto;
import com.example.stable_management.stbl_backend.dtos.FeedingDto;
import com.example.stable_management.stbl_backend.entities.FeedSchedule;
import com.example.stable_management.stbl_backend.entities.FeedServingSize;
import com.example.stable_management.stbl_backend.entities.FeedType;
import com.example.stable_management.stbl_backend.entities.Feeding;
import com.example.stable_management.stbl_backend.repositories.FeedScheduleRepository;
import com.example.stable_management.stbl_backend.services.interfaces.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedScheduleServiceImpl implements FeedScheduleService {

    private final FeedScheduleRepository feedScheduleRepository;
    private final HorseService horseService;
    private final FeedingService feedingService;
    private final FeedTypeService feedTypeService;
    private final FeedServingSizeService feedServingSizeService;

    public FeedScheduleServiceImpl(FeedScheduleRepository feedScheduleRepository, @Lazy HorseService horseService, FeedingService feedingService, FeedTypeService feedTypeService, FeedServingSizeService feedServingSizeService) {
        this.feedScheduleRepository = feedScheduleRepository;
        this.horseService = horseService;
        this.feedingService = feedingService;
        this.feedTypeService = feedTypeService;
        this.feedServingSizeService = feedServingSizeService;
    }

    @Override
    public List<FeedSchedule> getAllFeedSchedules() {
        return feedScheduleRepository.findAll();
    }

    @Override
    public FeedSchedule getFeedScheduleById(Long id) {
        return feedScheduleRepository.findById(id).orElse(null);
    }

    @Override
    public FeedSchedule createFeedSchedule(Long horseId) {
        FeedSchedule feedSchedule = feedScheduleRepository.save(new FeedSchedule());
        feedSchedule.assignHorse(horseService.getHorseById(horseId));

        FeedType feedType = feedTypeService.getFeedTypeByName("Nicht füttern")
                .orElseGet(() -> feedTypeService.createFeedType(new FeedTypeDto("Nicht füttern")));

        FeedServingSize feedServingSize = feedServingSizeService.getFeedServingSizeByName("Nicht füttern")
                .orElseGet(() -> feedServingSizeService.createFeedServingSize(new FeedServingSizeDto("Nicht füttern")));

        String[] feedTimes = {"Morgens", "Mittags", "Abends"};
        for (String feedTime : feedTimes) {
            Feeding feeding = feedingService.createFeeding(new FeedingDto(
                    feedTime,
                    feedSchedule.getId(),
                    feedType.getId(),
                    feedServingSize.getId()));
            feeding.assignFeedSchedule(feedSchedule);
        }

        return feedScheduleRepository.save(feedSchedule);
    }


}
