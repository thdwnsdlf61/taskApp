package com.example.taskapp1.controller;

import com.example.taskapp1.dto.TaskRequestDto;
import com.example.taskapp1.dto.TaskResponseDto;
import com.example.taskapp1.entity.Task;
import com.example.taskapp1.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto requestDto) {

        return new ResponseEntity<>(taskService.saveTask(requestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<TaskResponseDto> findAllTasks(
            @RequestParam
            LocalDateTime updateAt,
            String authorName
    ) {
        return taskService.findAllTasks(updateAt, authorName);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> findTaskById(@PathVariable Long id) {

        return new ResponseEntity<>(taskService.findTaskById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDto> updateTask(
            @PathVariable Long id,
            @RequestBody TaskRequestDto requestDto
    ) {
        return new ResponseEntity<>(taskService.updateTask(id, requestDto.getTasks(), requestDto.getAuthorName()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(
            @PathVariable Long id
    ) {
        taskService.deleteTask(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
