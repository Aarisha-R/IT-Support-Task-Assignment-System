package com.examly.springapp.controller;

import com.examly.springapp.model.Task;
import com.examly.springapp.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET ALL TASKS
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    // GET TASK BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        if (task == null) {
            return ResponseEntity.notFound().build(); // 404
        }
        return ResponseEntity.ok(task);
    }

    // CREATE TASK
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.saveTask(task));
    }

    // UPDATE TASK (REQUIRED BY TEST)
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @RequestBody Task task) {

        Task updated = taskService.updateTask(id, task);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // DELETE TASK (REQUIRED BY TEST)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build(); // 204
    }

    // UPDATE TASK STATUS
    @PutMapping("/{id}/status")
    public ResponseEntity<Task> updateTaskStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        Task task = taskService.getTaskById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        task.setStatus(status);
        return ResponseEntity.ok(taskService.saveTask(task));
    }

    // GET TASKS BY USER
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Task>> getTasksByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(taskService.getTasksByUserId(userId));
    }

    // GET TASKS BY STATUS
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable String status) {
        List<Task> tasks = taskService.getTasksByStatus(status);
        if (tasks.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        }
        return ResponseEntity.ok(tasks);
    }
}
