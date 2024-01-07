package com.alitafreshi.task_manager.task.service;

import com.alitafreshi.task_manager.task.model.Task;
import com.alitafreshi.task_manager.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task insertNewTask(Task newTask){
        return taskRepository.save(newTask);
    }

    public List<Task> getAllTaskListByUserId(Long userId){
        return taskRepository.findByUserId(userId);
    }
    public String deletedByTaskId(Long taskId){
        taskRepository.findById(taskId).orElseThrow(() -> new NoSuchElementException("Task not found with ID: " + taskId));
        taskRepository.deleteById(taskId);
        return "Task With ID" + " " + taskId + " " + "Deleted";
    }

}
