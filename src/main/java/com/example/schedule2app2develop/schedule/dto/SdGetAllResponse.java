package com.example.schedule2app2develop.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SdGetAllResponse {

    private final Long id;
    private final String author;
    private final String title;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public SdGetAllResponse(Long id, String author, String title, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
