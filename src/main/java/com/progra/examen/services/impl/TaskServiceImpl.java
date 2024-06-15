package com.progra.examen.services.impl;

import com.progra.examen.entities.Task;
import com.progra.examen.repositories.TaskRepository;
import com.progra.examen.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task update(Long id, Task task) {
        if (taskRepository.existsById(id)){
            task.setId(id);
            return taskRepository.save(task);
        }
        return null;
    }
    @Override
    public void delete(Long id) {
        if (taskRepository.existsById(id)){
            taskRepository.deleteById(id);
        }
    }
}
