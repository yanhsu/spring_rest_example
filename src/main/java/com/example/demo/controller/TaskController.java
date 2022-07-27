package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @ResponseBody
    @PostMapping(path = "/tasks", produces = "application/json;charset=UTF-8")
    public Object addTask(@Valid @RequestBody Task task) {
        Task result = taskRepository.save(task);

        return result;
    }

    @ResponseBody
    @DeleteMapping(path = "/tasks/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> deleteTask(@PathVariable(name = "id") Integer Id) {
        taskRepository.deleteById(Id);

        return null;
    }

    @ResponseBody
    @GetMapping(path = "/tasks", produces = "application/json;charset=UTF-8")
    public Object getAllTask() {
        List<Task> result = taskRepository.findAll();

        return result;
    }

    @ResponseBody
    @GetMapping(path = "/tasks/{id}", produces = "application/json;charset=UTF-8")
    public Object getTask(@PathVariable(name = "id") Integer Id) {
        Optional<Task> result = taskRepository.findById(Id);

        return result.get();
    }

    @ResponseBody
    @PutMapping (path = "/tasks/{id}", produces = "application/json;charset=UTF-8")
    public Object updateTask(@Valid @PathVariable(name = "id") Integer Id,@RequestBody Task obj) {
        Optional<Task> result = taskRepository.findById(Id);
        if(result != null) {
            Task task = result.get();
            task = obj;
            taskRepository.save(task);
        }
        return result.get();
    }

}
