package com.example.taskapp1.service;

import com.example.taskapp1.dto.TaskRequestDto;
import com.example.taskapp1.dto.TaskResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {
    TaskResponseDto saveTask(TaskRequestDto requestDto);

    List<TaskResponseDto> findAllTasks(LocalDateTime updateAt, String authorName);

    TaskResponseDto findTaskById(Long id);

    TaskResponseDto updateTask(Long id, String tasks, String autorName);

    void deleteTask(Long id);
}
