package com.example.schedule2app2develop.schedule.threelayer;

import com.example.schedule2app2develop.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
