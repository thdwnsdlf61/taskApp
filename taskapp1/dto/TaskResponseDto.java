package com.example.taskapp1.dto;

import com.example.taskapp1.entity.Task;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TaskResponseDto {
    Long id;
    String tasks;
    String authorName;
    LocalDateTime creatAt;
    LocalDateTime updateAt;

    public TaskResponseDto(Task task) {
        this.id = task.getId();
        this.tasks = task.getTasks();
        this.authorName = task.getAuthorName();
        this.creatAt = task.getCreateAt();
        this.updateAt = task.getUpdateAt();
    }
}
