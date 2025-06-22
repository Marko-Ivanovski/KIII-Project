package com.kiii.backend.service.application;

import com.kiii.backend.model.entity.Task;
import com.kiii.backend.model.dto.CreateTaskDto;
import com.kiii.backend.model.dto.DisplayTaskDto;
import com.kiii.backend.model.dto.UpdateTaskDto;
import com.kiii.backend.service.domain.TaskDomainService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskApplicationService {

    private final TaskDomainService domain;

    public TaskApplicationService(TaskDomainService domain) {
        this.domain = domain;
    }

    public DisplayTaskDto createTask(CreateTaskDto dto) {
        Task saved = domain.save(dto.toTask());
        return DisplayTaskDto.from(saved);
    }

    public List<DisplayTaskDto> getAllTasks() {
        return DisplayTaskDto.from(domain.findAll());
    }

    public DisplayTaskDto getTaskById(Long id) {
        Task t = domain.findById(id).orElseThrow(() -> new EntityNotFoundException("Task not found: " + id));
        return DisplayTaskDto.from(t);
    }

    public DisplayTaskDto updateTask(Long id, UpdateTaskDto dto) {
        Task existing = domain.findById(id).orElseThrow(() -> new EntityNotFoundException("Task not found: " + id));

        existing.setTitle(dto.title());
        existing.setDescription(dto.description());
        existing.setDueDate(dto.dueDate());
        existing.setCompleted(dto.completed());
        Task updated = domain.save(existing);

        return DisplayTaskDto.from(updated);
    }

    public void deleteTask(Long id) {
        domain.deleteById(id);
    }

    public DisplayTaskDto setCompletion(Long id, boolean completed) {
        Task updated = domain.markCompleted(id, completed);
        return DisplayTaskDto.from(updated);
    }
}
