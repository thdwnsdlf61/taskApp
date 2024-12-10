package com.example.taskapp1.entity;

import com.example.taskapp1.dto.TaskRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Task {

    @Setter
    Long id;
    String tasks;
    String authorName;
    @Setter
    LocalDateTime createAt;
    @Setter
    LocalDateTime updateAt;

    public Task(String task, String authorName) {
        this.tasks = task;
        this.authorName = authorName;
    }

    public void update(String tasks, String authorName) {
        this.tasks = tasks;
        this.authorName = authorName;
    }
}
