package com.nguyenduc.models.app;

import com.nguyenduc.models.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private boolean isDone;

    private Date createdAt;

    private Date updatedAt;

    @ManyToOne
    private User user;
}
