package com.example.stable_management.stbl_backend.services.implementations;

import com.example.stable_management.stbl_backend.dtos.FeedingDto;
import com.example.stable_management.stbl_backend.entities.FeedSchedule;
import com.example.stable_management.stbl_backend.entities.FeedServingSize;
import com.example.stable_management.stbl_backend.entities.Feeding;
import com.example.stable_management.stbl_backend.entities.FeedType;
import com.example.stable_management.stbl_backend.repositories.FeedingRepository;
import com.example.stable_management.stbl_backend.services.interfaces.FeedScheduleService;
import com.example.stable_management.stbl_backend.services.interfaces.FeedServingSizeService;
import com.example.stable_management.stbl_backend.services.interfaces.FeedingService;
import com.example.stable_management.stbl_backend.services.interfaces.FeedTypeService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FeedingServiceImpl implements FeedingService {

    private final FeedingRepository feedingRepository;
    private final FeedServingSizeService feedServingSizeService;
    private final FeedTypeService feedTypeService;
    private final FeedScheduleService feedScheduleService;

    public FeedingServiceImpl(FeedingRepository feedingRepository, FeedServingSizeService feedServingSizeService, FeedTypeService feedTypeService, @Lazy FeedScheduleService feedScheduleService) {
        this.feedingRepository = feedingRepository;
        this.feedServingSizeService = feedServingSizeService;
        this.feedTypeService = feedTypeService;
        this.feedScheduleService = feedScheduleService;
    }

    @Override
    public List<Feeding> getAllFeedTimes() {
        return feedingRepository.findAll();
    }

    @Override
    public Feeding getFeedTimeById(Long id) {
        return feedingRepository.findById(id).orElse(null);
    }

    @Override
    public Feeding createFeeding(FeedingDto feedingDto) {
        Feeding feeding = feedingRepository.save(new Feeding());
        feeding.setTimeExpression(feedingDto.time());
        feeding.assignFeedSchedule(feedScheduleService.getFeedScheduleById(feedingDto.scheduleId()));
        feeding.assignFeedType(feedTypeService.getFeedTypeById(feedingDto.typeId()));
        feeding.assignFeedServingSize(feedServingSizeService.getFeedServingSizeById(feedingDto.servingSizeId()));
        return feedingRepository.save(feeding);
    }

    @Override
    public Feeding assignFeedServingSizeToFeedTime(Long feedTimeId, Long feedServingSizeId) {
        if (getFeedTimeById(feedTimeId) == null || feedServingSizeService.getFeedServingSizeById(feedServingSizeId) == null) {
            throw new NoSuchElementException("Feed Time or Feed Serving Size not found");
        };
        Feeding feeding = getFeedTimeById(feedTimeId);
        FeedServingSize feedServingSize = feedServingSizeService.getFeedServingSizeById(feedServingSizeId);
        feeding.assignFeedServingSize(feedServingSize);
         return feedingRepository.save(feeding);
    }

    @Override
    public Feeding assignFeedTypeToFeedTime(Long feedTimeId, Long feedTypeId) {
        if (getFeedTimeById(feedTimeId) == null || feedTypeService.getFeedTypeById(feedTypeId) == null) {
            throw new NoSuchElementException("Feed Time or Feed Type not found");
        }
        Feeding feeding = getFeedTimeById(feedTimeId);
        FeedType feedType = feedTypeService.getFeedTypeById(feedTypeId);
        feeding.assignFeedType(feedType);
        return feedingRepository.save(feeding);
    }

    @Override
    public Feeding assignFeedScheduleToFeedTime(Long feedTimeId, Long feedScheduleId) {
        if (getFeedTimeById(feedTimeId) == null || feedScheduleService.getFeedScheduleById(feedScheduleId) == null) {
            throw new NoSuchElementException("Feed Time or Feed Schedule not found");
        }
        Feeding feeding = getFeedTimeById(feedTimeId);
        FeedSchedule feedSchedule = feedScheduleService.getFeedScheduleById(feedScheduleId);
        feeding.assignFeedSchedule(feedSchedule);
        return feedingRepository.save(feeding);
    }
}
