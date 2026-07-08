package com.example.schedule2app2develop.schedule.threelayer;

import com.example.schedule2app2develop.schedule.dto.SdCreateRequest;
import com.example.schedule2app2develop.schedule.dto.SdCreateResponse;
import com.example.schedule2app2develop.schedule.dto.SdGetAllResponse;
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
    public ResponseEntity<SdCreateResponse> create(@RequestBody SdCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sdService.create(request));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<SdGetAllResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(sdService.getAll());
    }

}
