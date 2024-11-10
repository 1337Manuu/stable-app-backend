package com.example.stable_management.stbl_backend.dtos.feed_schedule_dto;

import com.example.stable_management.stbl_backend.entities.FeedSchedule;
import lombok.Builder;

@Builder
public record FeedScheduleDtoForHorseRequest(
        Long id,
        String note
) {
    public static FeedScheduleDtoForHorseRequest getDto(FeedSchedule feedSchedule) {
        if (feedSchedule == null) return null;
        return builder()
                .id(feedSchedule.getId())
                .note(feedSchedule.getNote())
                .build();
    }
}
