package com.example.schedule2app2develop.schedule.threelayer;

import com.example.schedule2app2develop.schedule.dto.SdCreateRequest;
import com.example.schedule2app2develop.schedule.dto.SdCreateResponse;
import com.example.schedule2app2develop.schedule.dto.SdGetAllResponse;
import com.example.schedule2app2develop.schedule.dto.SdGetOneResponse;
import com.example.schedule2app2develop.schedule.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository sdRepository;

    @Transactional
    public SdCreateResponse create(SdCreateRequest request) {
        Schedule sd = new Schedule(
                request.getAuthor(),
                request.getTitle(),
                request.getContent()

        );
        Schedule created = sdRepository.save(sd);
        return new SdCreateResponse(
                created.getId(),
                created.getAuthor(),
                created.getTitle(),
                created.getContent(),
                created.getCreatedAt(),
                created.getModifiedAt()
        );

    }
    @Transactional(readOnly = true)
    public List<SdGetAllResponse> getAll() {
        List<Schedule> sdS = sdRepository.findAll();
        return sdS.stream()
                .map(Schedule -> new SdGetAllResponse(
                        Schedule.getId(),
                        Schedule.getTitle()
                )).toList();

    }
    @Transactional(readOnly = true)
    public SdGetOneResponse getOne(Long scheduleId) {
        Schedule schedule = sdRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다.")
        );
        return new SdGetOneResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent()
        );

    }
}
