package com.nguyenduc.controllers;

import com.nguyenduc.models.app.Todo;
import com.nguyenduc.models.app.TodoForm;
import com.nguyenduc.models.user.User;
import com.nguyenduc.services.category.ICategoryService;
import com.nguyenduc.services.todo.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private ITodoService postService;

    @Autowired
    private ICategoryService categoryService;

    @PostMapping
    public ResponseEntity<Todo> createPost(@RequestBody TodoForm todoForm) {
        Todo todo = new Todo();
        todo.setTitle(todoForm.getTitle());
        todo.setContent(todoForm.getContent());
        todo.setDone(false);
        todo.setCreatedAt(new Date());
        todo.setCategory(todoForm.getCategory());
        todo.setDateline(todoForm.getDateline());
        todo.setTask(todoForm.getTask());
        User user = new User();
        user.setId(1L);
        todo.setUser(user);
        return new ResponseEntity<>(postService.save(todo), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Todo>> getAllPost() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findById(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updatePost(@PathVariable Long id,@RequestBody TodoForm todoForm) {
        Todo todo = postService.findById(id).get();
        todo.setTitle(todoForm.getTitle());
        todo.setContent(todoForm.getContent());
        todo.setDone(todoForm.isDone());
        todo.setUpdatedAt(new Date());
        todo.setCategory(todoForm.getCategory());
        todo.setDateline(todoForm.getDateline());
        todo.setTask(todoForm.getTask());
        User user = new User();
        user.setId(1L);
        todo.setUser(user);
        return ResponseEntity.ok(postService.save(todo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Todo> deletePost(@PathVariable Long id) {
        postService.remove(id);
        return ResponseEntity.ok().build();
    }
}
