package com.examly.springapp.service;

import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Optional<Task> existing = taskRepository.findById(id);
        if (existing.isEmpty()) {
            return null;
        }

        Task t = existing.get();
        t.setTitle(task.getTitle());
        t.setDescription(task.getDescription());
        t.setPriority(task.getPriority());
        t.setStatus(task.getStatus());
        t.setDueDate(task.getDueDate());
        t.setCreatedBy(task.getCreatedBy());

        return taskRepository.save(t);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByCreatedById(userId);
    }

    @Override
    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }
}
