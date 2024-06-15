package com.progra.examen.controllers;

import com.progra.examen.entities.Task;
import com.progra.examen.services.TaskService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> GetAll(){
        return taskService.findAll();
    }

    @GetMapping(value="/{id}")
    public Task GetById(@PathVariable Long id){
        return taskService.findById(id);
    }


    @PostMapping
    public Task create( @Valid @RequestBody Task task){
        return taskService.create(task);
    }

    @PutMapping(value="/{id}")
    public Task update (@PathVariable Long id,
                        @RequestBody Task task){
        return taskService.update(id, task);
    }

    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable Long id){
        taskService.delete(id);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(
            MethodArgumentNotValidException ex
    ){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
