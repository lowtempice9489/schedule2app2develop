package com.example.schedule2app2develop.schedule.threelayer;

import com.example.schedule2app2develop.schedule.dto.*;
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
    @Transactional
    public SdUpdateResponse update(Long scheduleId, SdUpdateRequest request) {
        Schedule schedule = sdRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다.")
        );
        schedule.update(request.getTitle(), request.getContent());
        return new SdUpdateResponse(schedule.getId());
    }
    @Transactional
    public void delete(Long scheduleId) {
        boolean existence = sdRepository.existsById(scheduleId);
        if (!existence) {
            throw new IllegalStateException("없는 게시글 입니다.");
        }
        sdRepository.deleteById(scheduleId);
    }
}
