package com.nguyenduc.controllers;

import com.nguyenduc.models.app.Task;
import com.nguyenduc.models.app.TaskForm;
import com.nguyenduc.models.user.User;
import com.nguyenduc.services.task.ITaskService;
import com.nguyenduc.services.todo.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private ITaskService taskService;

    @Autowired
    private ITodoService todoService;

    @GetMapping
    public ResponseEntity<Iterable<Task>> getAllTask() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskForm taskForm) {
        Task task = new Task();
        task.setContent(taskForm.getContent());
        task.setCreatedAt(new Date());
        task.setDone(false);
        User user = new User();
        user.setId(1L);
        task.setUser(user);
        return ResponseEntity.ok(taskService.save(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id ,@RequestBody TaskForm taskForm) {
        Task task = taskService.findById(id).get();
        task.setContent(taskForm.getContent());
        task.setDone(taskForm.isDone());
        task.setUpdatedAt(new Date());
        User user = new User();
        user.setId(1L);
        task.setUser(user);
        return ResponseEntity.ok(taskService.save(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        todoService.deleteAllByTaskId(id);
        taskService.remove(id);
        return ResponseEntity.ok().build();
    }
}
