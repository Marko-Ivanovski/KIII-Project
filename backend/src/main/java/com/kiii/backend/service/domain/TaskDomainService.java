package com.kiii.backend.service.domain;

import com.kiii.backend.model.entity.Task;
import com.kiii.backend.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskDomainService {

    private final TaskRepository repository;

    public TaskDomainService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task save(Task task) {
        return repository.save(task);
    }

    public Optional<Task> findById(Long id) {
        return repository.findById(id);
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Task markCompleted(Long id, boolean completed) {
        Task task = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task not found: " + id));
        task.setCompleted(completed);
        return repository.save(task);
    }
}