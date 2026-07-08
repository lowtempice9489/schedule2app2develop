package com.example.schedule2app2develop.schedule.dto;

import lombok.Getter;

@Getter
public class SdGetOneResponse {

    private final Long id;
    private final String title;
    private final String content;

    public SdGetOneResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
