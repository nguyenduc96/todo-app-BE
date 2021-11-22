package com.nguyenduc.repositories;

import com.nguyenduc.models.app.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ITodoRepository extends JpaRepository<Todo, Long> {
    @Transactional
    void deleteAllByTaskId(Long taskId);
}
