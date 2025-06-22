package com.kiii.backend.model.dto;

import java.time.LocalDate;

public record UpdateTaskDto(
        String title,
        String description,
        LocalDate dueDate,
        boolean completed
) {}
