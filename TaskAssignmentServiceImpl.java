package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.TaskAssignment;
import com.examly.springapp.repository.TaskAssignmentRepository;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    @Autowired
    private TaskAssignmentRepository assignmentRepository;

    @Override
    public TaskAssignment addAssignment(TaskAssignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public List<TaskAssignment> getAssignmentsByUserId(Long userId) {
        return assignmentRepository.findByUserId(userId);
    }
}