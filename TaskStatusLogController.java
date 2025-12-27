package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.TaskStatusLog;
import com.examly.springapp.service.TaskStatusLogService;

@RestController
@RequestMapping("/api/status-logs")
public class TaskStatusLogController {

    @Autowired
    private TaskStatusLogService service;

    // POST /api/status-logs
    @PostMapping
    public ResponseEntity<TaskStatusLog> addStatusLog(@RequestBody TaskStatusLog log) {
        return new ResponseEntity<>(service.addStatusLog(log), HttpStatus.CREATED);
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<TaskStatusLog>> getAllStatusLogs() {
        return ResponseEntity.ok(service.getAllStatusLogs());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<TaskStatusLog> getStatusLogById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStatusLogById(id));
    }

    // GET BY TASK ID
    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<TaskStatusLog>> getLogsByTask(@PathVariable Long taskId) {
        return ResponseEntity.ok(service.getLogsByTaskId(taskId));
    }

    // GET BY OLD STATUS (NEGATIVE CASE IMPORTANT)
    @GetMapping("/old/{oldStatus}")
    public ResponseEntity<?> getLogsByOldStatus(@PathVariable String oldStatus) {

        List<TaskStatusLog> logs = service.getLogsByOldStatus(oldStatus);

        if (logs.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("No logs found with oldStatus: " + oldStatus);
        }

        return ResponseEntity.ok(logs);
    }
}