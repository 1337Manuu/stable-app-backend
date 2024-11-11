package com.example.stable_management.stbl_backend.dtos.feed_time_dto;

import com.example.stable_management.stbl_backend.dtos.feed_serving_size_dto.FeedServingSizeDto;
import com.example.stable_management.stbl_backend.dtos.feed_type_dto.FeedTypeDto;
import com.example.stable_management.stbl_backend.entities.FeedTime;
import lombok.Builder;

@Builder
public record FeedTimeDto(
        Long id,
        String timeExpression,
        FeedServingSizeDto servingSizeDto,
        FeedTypeDto feedTypeDto
) {
    public static FeedTimeDto getDto(FeedTime feedTime){
        if (feedTime == null) return null;
        return FeedTimeDto.builder()
                .id(feedTime.getId())
                .timeExpression(feedTime.getTimeExpression())
                .servingSizeDto(FeedServingSizeDto.getDto(feedTime.getFeedServingSize()))
                .feedTypeDto(FeedTypeDto.getDto(feedTime.getFeedType()))
                .build();
    }
}
