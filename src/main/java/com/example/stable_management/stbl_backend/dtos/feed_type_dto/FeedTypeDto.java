package com.example.stable_management.stbl_backend.dtos.feed_type_dto;

import com.example.stable_management.stbl_backend.entities.FeedType;
import lombok.Builder;

@Builder
public record FeedTypeDto(
        Long id,
        String name
) {
    public static FeedTypeDto getDto(FeedType feedType) {
        if (feedType == null) return null;
        return builder()
                .id(feedType.getId())
                .name(feedType.getName())
                .build();
    }
}
