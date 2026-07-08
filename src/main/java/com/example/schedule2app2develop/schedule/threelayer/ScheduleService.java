package com.example.schedule2app2develop.schedule.threelayer;

import com.example.schedule2app2develop.schedule.dto.*;
import com.example.schedule2app2develop.schedule.entity.Schedule;
import com.example.schedule2app2develop.user.entity.User;
import com.example.schedule2app2develop.user.threelayer.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository sdRepository;
    private final UserRepository urRepository;

    @Transactional
    public SdCreateResponse create(Long loginUserId, SdCreateRequest request) {
        User user = urRepository.findById(loginUserId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 유저입니다.")
        );
        Schedule sd = new Schedule(
                user,
                request.getTitle(),
                request.getContent()

        );
        Schedule created = sdRepository.save(sd);
        return new SdCreateResponse(
                created.getId(),
                created.getUser().getId(),
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
                        Schedule.getUser().getId(),
                        Schedule.getTitle(),
                        Schedule.getCreatedAt(),
                        Schedule.getModifiedAt()
                )).toList();

    }
    @Transactional(readOnly = true)
    public SdGetOneResponse getOne(Long scheduleId) {
        Schedule schedule = sdRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다.")
        );
        return new SdGetOneResponse(
                schedule.getId(),
                schedule.getUser().getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );

    }
    @Transactional
    public SdUpdateResponse update(Long scheduleId, Long loginUserId, SdUpdateRequest request) {
        Schedule schedule = sdRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다.")
        );
        if (!schedule.getUser().getId().equals(loginUserId)) {
            throw new IllegalStateException("본인의 일정만 수정할 수 있습니다.");
        }
        schedule.update(request.getTitle(), request.getContent());
        return new SdUpdateResponse(schedule.getId(), schedule.getTitle(), schedule.getContent(), schedule.getModifiedAt());
    }
    @Transactional
    public void delete(Long scheduleId, Long loginUserId) {
        Schedule schedule = sdRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("없는 게시글 입니다.")
        );
        if (!schedule.getUser().getId().equals(loginUserId)) {
            throw new IllegalStateException("본인의 일정만 삭제할 수 있습니다.");
        }
        sdRepository.deleteById(scheduleId);
    }
}
