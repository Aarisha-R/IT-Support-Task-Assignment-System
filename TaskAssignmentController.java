package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.TaskAssignment;
import com.examly.springapp.service.TaskAssignmentService;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {

    @Autowired
    private TaskAssignmentService assignmentService;

    @PostMapping
    public TaskAssignment addAssignment(@RequestBody TaskAssignment assignment) {
        return assignmentService.addAssignment(assignment);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getAssignmentsByUser(@PathVariable Long userId) {

        List<TaskAssignment> list = assignmentService.getAssignmentsByUserId(userId);

        if (list.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("No assignments found for user id: " + userId);
        }

        return ResponseEntity.ok(list);
    }
}