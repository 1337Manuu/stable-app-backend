package com.example.stable_management.stbl_backend.dtos.feed_schedule_dto;

import com.example.stable_management.stbl_backend.dtos.feed_time_dto.FeedTimeDto;
import com.example.stable_management.stbl_backend.dtos.horse_dto.HorseDtoForFeedScheduleRequest;
import com.example.stable_management.stbl_backend.entities.FeedSchedule;
import lombok.Builder;

import java.util.List;

@Builder
public record FeedScheduleDto(
        Long id,
        String note,
        HorseDtoForFeedScheduleRequest horseDto,
        List<FeedTimeDto> feedTimeDtoList
) {
    public static FeedScheduleDto getDto(FeedSchedule feedSchedule) {
        if (feedSchedule == null) return null;
        return FeedScheduleDto.builder()
                .id(feedSchedule.getId())
                .note(feedSchedule.getNote())
                .horseDto(HorseDtoForFeedScheduleRequest.getDto(feedSchedule.getHorse()))
                .feedTimeDtoList(feedSchedule.getFeedTimes().stream().map(FeedTimeDto::getDto).toList())
                .build();
    }
}
