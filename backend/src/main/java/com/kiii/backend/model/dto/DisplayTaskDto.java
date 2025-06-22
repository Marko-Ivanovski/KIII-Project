package com.kiii.backend.model.dto;

import com.kiii.backend.model.entity.Task;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record DisplayTaskDto(
        Long id,
        String title,
        String description,
        LocalDate dueDate,
        boolean completed
) {
    public static DisplayTaskDto from(Task task) {
        return new DisplayTaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.isCompleted()
        );
    }

    public static List<DisplayTaskDto> from(List<Task> tasks) {
        return tasks.stream()
                .map(DisplayTaskDto::from)
                .collect(Collectors.toList());
    }
}
