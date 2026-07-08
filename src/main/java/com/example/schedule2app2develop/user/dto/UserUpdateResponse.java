package com.example.schedule2app2develop.user.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserUpdateResponse {

    private final Long id;
    private final String username;
    private final String email;
    private final LocalDateTime modifiedAt;

    public UserUpdateResponse(Long id, String username, String email, LocalDateTime modifiedAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.modifiedAt = modifiedAt;
    }
}
