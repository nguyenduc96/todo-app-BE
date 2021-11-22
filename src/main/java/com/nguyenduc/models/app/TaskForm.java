package com.nguyenduc.models.app;

import com.nguyenduc.models.user.User;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class TaskForm {
    private Long id;

    private String content;

    private boolean isDone;

    private User user;
}
