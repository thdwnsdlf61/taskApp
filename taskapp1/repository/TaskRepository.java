package com.example.taskapp1.repository;

import com.example.taskapp1.dto.TaskResponseDto;
import com.example.taskapp1.entity.Task;

import java.util.List;

public interface TaskRepository {
    Task saveTask(Task task);

    List<TaskResponseDto> findAllTasks();

    Task findTaskById(Long id);

    void deleteTask(Long id);
}
