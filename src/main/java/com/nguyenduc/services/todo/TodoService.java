package com.nguyenduc.services.todo;

import com.nguyenduc.models.app.Todo;
import com.nguyenduc.repositories.ITodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService implements ITodoService {
    @Autowired
    private ITodoRepository todoRepository;

    @Override
    public Iterable<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Page<Todo> findAll(Pageable pageable) {
        return todoRepository.findAll(pageable);
    }

    @Override
    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void remove(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public void deleteAllByTaskId(Long taskId) {
        todoRepository.deleteAllByTaskId(taskId);
    }
}
