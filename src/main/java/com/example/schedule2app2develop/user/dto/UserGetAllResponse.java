package com.example.schedule2app2develop.user.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserGetAllResponse {

    private final Long id;
    private final String username;
    private final String email;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public UserGetAllResponse(Long id, String username, String email, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
