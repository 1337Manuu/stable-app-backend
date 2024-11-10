package com.example.stable_management.stbl_backend.dtos.feed_serving_size_dto;

import com.example.stable_management.stbl_backend.entities.FeedServingSize;
import lombok.Builder;

@Builder
public record FeedServingSizeDto(
        Long id,
        String name
) {
    public static FeedServingSizeDto getDto(FeedServingSize feedServingSize) {
        if (feedServingSize == null) return null;
        return builder()
                .id(feedServingSize.getId())
                .name(feedServingSize.getName())
                .build();
    }
}
