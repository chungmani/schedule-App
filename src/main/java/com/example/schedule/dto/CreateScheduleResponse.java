package com.example.schedule.dto;

import lombok.Getter;

@Getter
public class CreateScheduleResponse {

    private final Long id;
    private final String title;
    private final String content;

    public CreateScheduleResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
