package com.example.schedule2app2develop.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "Users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends UserTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;

    }

    public void update(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
