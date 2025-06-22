package com.kiii.backend.model.dto;

import com.kiii.backend.model.entity.Task;
import java.time.LocalDate;

public record CreateTaskDto(String title, String description, LocalDate dueDate) {
    public Task toTask() {
        return Task.builder()
                .title(this.title)
                .description(this.description)
                .dueDate(this.dueDate)
                .completed(false)
                .build();
    }
}