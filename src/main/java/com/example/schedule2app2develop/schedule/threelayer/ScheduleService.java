package com.example.schedule2app2develop.schedule.threelayer;

import com.example.schedule2app2develop.schedule.dto.SdCreateRequest;
import com.example.schedule2app2develop.schedule.dto.SdCreateResponse;
import com.example.schedule2app2develop.schedule.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
