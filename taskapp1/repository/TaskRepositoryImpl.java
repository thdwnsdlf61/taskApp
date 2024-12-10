package com.example.taskapp1.repository;

import com.example.taskapp1.dto.TaskResponseDto;
import com.example.taskapp1.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TaskRepositoryImpl implements TaskRepository{
    private final Map<Long, Task> taskList = new HashMap<>();

    @Override
    public Task saveTask(Task task) {

        Long taskId = taskList.isEmpty() ? 1 : Collections.max(taskList.keySet()) + 1;
        task.setId(taskId);
        taskList.put(taskId, task);
        return task;
    }

    @Override
    public List<TaskResponseDto> findAllTasks() {

        List<TaskResponseDto> allTasks = new ArrayList<>();

        for (Task task : taskList.values()) {
            TaskResponseDto responseDto = new TaskResponseDto(task);
            allTasks.add(responseDto);
        }

        return allTasks;
    }

    @Override
    public Task findTaskById(Long id) {
        return taskList.get(id);
    }

    @Override
    public void deleteTask(Long id) {
        taskList.remove(id);
    }
}
