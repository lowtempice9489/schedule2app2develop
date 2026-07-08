package com.example.schedule2app2develop.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SdGetAllResponse {

    private final Long id;
    private final Long userId;
    private final String title;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public SdGetAllResponse(Long id, Long userId, String title, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
