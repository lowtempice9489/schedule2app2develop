package com.example.schedule2app2develop.user.threelayer;

import com.example.schedule2app2develop.user.dto.UserCreateRequest;
import com.example.schedule2app2develop.user.dto.UserCreateResponse;
import com.example.schedule2app2develop.user.dto.UserGetAllResponse;
import com.example.schedule2app2develop.user.dto.UserGetOneResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService urService;

    @PostMapping("/users")
    public ResponseEntity<UserCreateResponse> create(@RequestBody UserCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(urService.create(request));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserGetAllResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(urService.getAll());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserGetOneResponse> getOne(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(urService.getOne(userId));
    }
}
