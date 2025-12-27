package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.TaskAssignment;

public interface TaskAssignmentService {

    TaskAssignment addAssignment(TaskAssignment assignment);

    List<TaskAssignment> getAssignmentsByUserId(Long userId);
}