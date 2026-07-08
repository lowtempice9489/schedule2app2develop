package com.example.schedule2app2develop.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SdUpdateResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime modifiedAt;


    public SdUpdateResponse(Long id, String title, String content, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.modifiedAt = modifiedAt;
    }
}
