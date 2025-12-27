package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.TaskStatusLog;
import com.examly.springapp.repository.TaskStatusLogRepository;

@Service
public class TaskStatusLogServiceImpl implements TaskStatusLogService {

    @Autowired
    private TaskStatusLogRepository repository;

    @Override
    public TaskStatusLog addStatusLog(TaskStatusLog log) {
        return repository.save(log);
    }

    @Override
    public List<TaskStatusLog> getAllStatusLogs() {
        return repository.findAll();
    }

    @Override
    public TaskStatusLog getStatusLogById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<TaskStatusLog> getLogsByTaskId(Long taskId) {
        return repository.findByTaskId(taskId);
    }

    @Override
    public List<TaskStatusLog> getLogsByOldStatus(String oldStatus) {
        return repository.findByOldStatus(oldStatus);
    }
}