package com.progra.examen.services;

import com.progra.examen.entities.Task;

import java.util.List;


public interface TaskService {
    public List<Task> findAll();
    public Task findById(Long id);
    public Task create(Task task);
    public Task update(Long id, Task task);
    public void delete(Long id);

}
