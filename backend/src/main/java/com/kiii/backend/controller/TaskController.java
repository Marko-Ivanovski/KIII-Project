package com.kiii.backend.controller;

import com.kiii.backend.model.dto.CreateTaskDto;
import com.kiii.backend.model.dto.DisplayTaskDto;
import com.kiii.backend.model.dto.UpdateTaskDto;
import com.kiii.backend.service.application.TaskApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.InetAddress;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Tasks", description = "CRUD operations for Task resource")
public class TaskController {

    private final TaskApplicationService service;

    public TaskController(TaskApplicationService service) {
        this.service = service;
    }

    private void logPod(String operation) {
        try {
            String hostname = InetAddress.getLocalHost().getHostName();
            System.out.println(operation + " handled by pod: " + hostname);
        } catch (Exception e) {
            System.err.println("Could not resolve hostname for operation " + operation + ": " + e.getMessage());
        }
    }

    @Operation(summary = "Create a new task", description = "Creates a new task with title, description, and due date. Completed defaults to false.")
    @PostMapping
    public ResponseEntity<DisplayTaskDto> createTask(@RequestBody CreateTaskDto dto) {
        logPod("POST /tasks");
        DisplayTaskDto created = service.createTask(dto);
        return ResponseEntity.status(201).body(created);
    }

    @Operation(summary = "Get all tasks", description = "Retrieves a list of all tasks.")
    @GetMapping
    public ResponseEntity<List<DisplayTaskDto>> getAllTasks() {
        logPod("GET /tasks");
        List<DisplayTaskDto> tasks = service.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @Operation(summary = "Get a task by ID", description = "Fetches the task with the specified ID.")
    @GetMapping("/{id}")
    public ResponseEntity<DisplayTaskDto> getTask(@PathVariable Long id) {
        logPod("GET /tasks/" + id);
        DisplayTaskDto dto = service.getTaskById(id);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Update a task", description = "Updates title, description, due date, and completion state of an existing task.")
    @PutMapping("/{id}")
    public ResponseEntity<DisplayTaskDto> updateTask(
            @PathVariable Long id,
            @RequestBody UpdateTaskDto dto) {
        logPod("PUT /tasks/" + id);
        DisplayTaskDto updated = service.updateTask(id, dto);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Delete a task", description = "Deletes the task with the given ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        logPod("DELETE /tasks/" + id);
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Set completion status", description = "Sets the completion status (true or false) for a task.")
    @PatchMapping("/{id}/completion")
    public ResponseEntity<DisplayTaskDto> setCompletion(
            @PathVariable Long id,
            @RequestParam boolean completed) {
        logPod("PATCH /tasks/" + id + "/completion?completed=" + completed);
        DisplayTaskDto dto = service.setCompletion(id, completed);
        return ResponseEntity.ok(dto);
    }
}
