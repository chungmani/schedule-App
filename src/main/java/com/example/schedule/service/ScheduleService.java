package com.example.schedule.service;

import com.example.schedule.dto.CreateScheduleRequest;
import com.example.schedule.dto.CreateScheduleResponse;
import com.example.schedule.dto.GetScheduleResponse;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CreateScheduleResponse createSchedule(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(request.getTitle(), request.getContent(), request.getName(), request.getPassword());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new CreateScheduleResponse(savedSchedule.getId(), savedSchedule.getTitle(), savedSchedule.getContent());
    }

    @Transactional(readOnly = true)
    public GetScheduleResponse findOne(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );
        return new GetScheduleResponse(schedule.getId(), schedule.getTitle(), schedule.getContent(), schedule.getName());
    }

    @Transactional(readOnly = true)
    public List<GetScheduleResponse> findAll(String name) {

        List<Schedule> schedules;
        List<GetScheduleResponse> dtos = new ArrayList<>();
        GetScheduleResponse dto;

        if (name == null) {
            schedules = scheduleRepository.findAll(Sort.by(Sort.Direction.DESC, "modifiedDate"));
        } else {
            schedules = scheduleRepository.findAllByName(name, Sort.by(Sort.Direction.DESC, "modifiedDate"));
        }

        for (Schedule schedule : schedules) {
            dto = new GetScheduleResponse(schedule.getId(), schedule.getTitle(), schedule.getContent(), schedule.getName());
            dtos.add(dto);
        }

        return dtos;
    }
}

