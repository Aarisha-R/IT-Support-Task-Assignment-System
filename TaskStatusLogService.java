package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.TaskStatusLog;

public interface TaskStatusLogService {

    TaskStatusLog addStatusLog(TaskStatusLog log);

    List<TaskStatusLog> getAllStatusLogs();

    TaskStatusLog getStatusLogById(Long id);

    List<TaskStatusLog> getLogsByTaskId(Long taskId);

    List<TaskStatusLog> getLogsByOldStatus(String oldStatus);
}