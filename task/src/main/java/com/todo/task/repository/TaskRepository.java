package com.todo.task.repository;

import com.todo.task.modelEntity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
