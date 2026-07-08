package com.example.schedule2app2develop.user.threelayer;

import com.example.schedule2app2develop.user.dto.UserCreateRequest;
import com.example.schedule2app2develop.user.dto.UserCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService UrService;

    @PostMapping("/users")
    public ResponseEntity<UserCreateResponse> create(@RequestBody UserCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(UrService.create(request));
    }
}
