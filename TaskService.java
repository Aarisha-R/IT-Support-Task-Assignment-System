package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Task;

public interface TaskService {

    Task saveTask(Task task);

    Task getTaskById(Long id);

    List<Task> getAllTasks();

    Task updateTask(Long id, Task task);

    void deleteTask(Long id);

    List<Task> getTasksByUserId(Long userId);

    List<Task> getTasksByStatus(String status);
}
