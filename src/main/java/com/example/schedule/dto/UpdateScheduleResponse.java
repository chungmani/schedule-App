package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponse {

    private final Long id;
    private final String title;
    private final String name;
    private final LocalDateTime modifiedDate;

    public UpdateScheduleResponse(Long id, String title, String name, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.modifiedDate = modifiedDate;
    }
}
