package com.nguyenduc.services.todo;

import com.nguyenduc.models.app.Todo;
import com.nguyenduc.services.IGeneralService;
import org.springframework.stereotype.Service;


public interface ITodoService extends IGeneralService<Todo> {
    void deleteAllByTaskId(Long taskId);
}
