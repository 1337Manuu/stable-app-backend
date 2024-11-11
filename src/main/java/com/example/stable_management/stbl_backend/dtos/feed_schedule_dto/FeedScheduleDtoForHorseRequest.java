package com.example.stable_management.stbl_backend.dtos.feed_schedule_dto;

import com.example.stable_management.stbl_backend.dtos.feed_time_dto.FeedTimeDto;
import com.example.stable_management.stbl_backend.dtos.feed_time_dto.FeedTimeDtoForFeedScheduleRequest;
import com.example.stable_management.stbl_backend.entities.FeedSchedule;
import lombok.Builder;

import java.util.List;

@Builder
public record FeedScheduleDtoForHorseRequest(
        Long id,
        String note,
        List<FeedTimeDtoForFeedScheduleRequest> feedTimeDtoList
) {
    public static FeedScheduleDtoForHorseRequest getDto(FeedSchedule feedSchedule) {
        if (feedSchedule == null) return null;
        return builder()
                .id(feedSchedule.getId())
                .note(feedSchedule.getNote())
                .feedTimeDtoList(feedSchedule.getFeedTimes().stream().map(FeedTimeDtoForFeedScheduleRequest::getDto).toList())
                .build();
    }
}
