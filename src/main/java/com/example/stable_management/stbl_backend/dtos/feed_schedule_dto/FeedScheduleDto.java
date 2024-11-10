package com.example.stable_management.stbl_backend.dtos.feed_schedule_dto;

import com.example.stable_management.stbl_backend.dtos.horse_dto.HorseDtoForFeedScheduleRequest;
import com.example.stable_management.stbl_backend.entities.FeedSchedule;
import lombok.Builder;

@Builder
public record FeedScheduleDto(
        Long id,
        String note,
        HorseDtoForFeedScheduleRequest horseDto
) {
    public static FeedScheduleDto getDto(FeedSchedule feedSchedule) {
        if (feedSchedule == null) return null;
        return FeedScheduleDto.builder()
                .id(feedSchedule.getId())
                .note(feedSchedule.getNote())
                .build();
    }
}
