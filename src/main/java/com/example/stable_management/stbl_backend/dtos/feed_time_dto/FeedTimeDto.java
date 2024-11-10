package com.example.stable_management.stbl_backend.dtos.feed_time_dto;

import com.example.stable_management.stbl_backend.entities.FeedTime;
import lombok.Builder;

@Builder
public record FeedTimeDto(
        Long id,
        String timeExpression
) {
    public static FeedTimeDto getDto(FeedTime feedTime){
        if (feedTime == null) return null;
        return FeedTimeDto.builder()
                .id(feedTime.getId())
                .timeExpression(feedTime.getTimeExpression())
                .build();
    }
}
