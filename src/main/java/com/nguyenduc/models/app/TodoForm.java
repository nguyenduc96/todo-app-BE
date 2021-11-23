package com.nguyenduc.models.app;

import com.nguyenduc.models.user.User;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Data
@Validated
public class TodoForm {
    private Long id;

    private Long position;

    private String content;

    private boolean isDone;

    private Date dateline;

    private User user;

    private Category category;

    private Task task;
}
