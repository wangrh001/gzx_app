package com.bangnd.mis.service;

import com.bangnd.mis.entity.Task;
import com.bangnd.mis.form.TaskSearchForm;

import java.util.List;

public interface TaskService {
    public List<Task> getTaskList(TaskSearchForm taskSearchForm);

    public void save(Task task);

    public Task getTaskById(long id);

    public void merge(Task task);
}