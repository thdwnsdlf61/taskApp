package com.example.taskapp1.service;

import com.example.taskapp1.dto.TaskRequestDto;
import com.example.taskapp1.dto.TaskResponseDto;
import com.example.taskapp1.entity.Task;
import com.example.taskapp1.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskResponseDto saveTask(TaskRequestDto requestDto) {

        Task task = new Task(requestDto.getTasks(), requestDto.getAuthorName());
        LocalDateTime now = LocalDateTime.now();
        task.setCreateAt(now);
        task.setUpdateAt(now);

        Task saveTask = taskRepository.saveTask(task);

        return new TaskResponseDto(saveTask);
    }

    @Override
    public List<TaskResponseDto> findAllTasks(LocalDateTime updateAt, String authorName) {
        List<TaskResponseDto> allTasks = taskRepository.findAllTasks();
        return allTasks;
    }

    @Override
    public TaskResponseDto findTaskById(Long id) {
        Task task = taskRepository.findTaskById(id);

        if (task == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        return new TaskResponseDto(task);
    }

    @Override
    public TaskResponseDto updateTask(Long id, String tasks, String authorName) {
        Task task = taskRepository.findTaskById(id);
        LocalDateTime now = LocalDateTime.now();
        task.setUpdateAt(now);

        if (tasks == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        if (tasks == null || authorName == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and content are required values.");
        }

        task.update(tasks, authorName);
        return new TaskResponseDto(task);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findTaskById(id);

        if (task == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
        taskRepository.deleteTask(id);
    }
}
