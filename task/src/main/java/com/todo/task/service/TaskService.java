package com.todo.task.service;

import com.todo.task.modelEntity.Task;
import com.todo.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);

    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Task id"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
