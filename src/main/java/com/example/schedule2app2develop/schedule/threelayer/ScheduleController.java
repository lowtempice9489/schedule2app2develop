package com.example.schedule2app2develop.schedule.threelayer;

import com.example.schedule2app2develop.schedule.dto.*;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService sdService;

    @PostMapping("/schedules")
    public ResponseEntity<SdCreateResponse> create(
            @RequestBody SdCreateRequest request,
            HttpSession session
    ) {
        Long loginUserId = (Long) session.getAttribute("LOGIN_USER");

        if (loginUserId == null) {
            throw new IllegalStateException("로그인이 필요합니다.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(sdService.create(request));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<SdGetAllResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(sdService.getAll());
    }

    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<SdGetOneResponse> getOne(@PathVariable Long scheduleId) {
        return ResponseEntity.status(HttpStatus.OK).body(sdService.getOne(scheduleId));

    }

    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<SdUpdateResponse> update(
            @PathVariable Long scheduleId,
            @RequestBody SdUpdateRequest request,
            HttpSession session
    ) {
        Long loginUserId = (Long) session.getAttribute("LOGIN_USER");

        if (loginUserId == null) {
            throw new IllegalStateException("로그인이 필요합니다.");
        }
        return  ResponseEntity.status(HttpStatus.OK).body(sdService.update(scheduleId, request));
    }

    @DeleteMapping("/schedules/{scheduleId}")
    public ResponseEntity<Void> sdDelete(@PathVariable Long scheduleId, HttpSession session) {
        Long loginUserId = (Long) session.getAttribute("LOGIN_USER");

        if (loginUserId == null) {
            throw new IllegalStateException("로그인이 필요합니다.");
        }
        sdService.delete(scheduleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
