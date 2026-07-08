package com.example.schedule2app2develop.schedule.dto;

import lombok.Getter;

@Getter
public class SdUpdateResponse {

    private final Long id;


    public SdUpdateResponse(Long id) {
        this.id = id;

    }
}
