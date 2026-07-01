package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetScheduleResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String name;
    private final LocalDateTime modifiedDate;

    public GetScheduleResponse(Long id, String title, String content, String name, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.name = name;
        this.modifiedDate = modifiedDate;
    }
}
