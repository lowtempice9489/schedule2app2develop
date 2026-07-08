package com.example.schedule2app2develop.schedule.dto;

import lombok.Getter;

@Getter
public class SdGetAllResponse {

    private final Long id;
    private final String title;

    public SdGetAllResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
