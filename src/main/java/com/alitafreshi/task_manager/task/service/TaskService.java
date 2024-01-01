package com.alitafreshi.task_manager.task.service;

import com.alitafreshi.task_manager.task.model.Task;
import com.alitafreshi.task_manager.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void insertNewTask(Task newTask){
        taskRepository.save(newTask);
    }

    public List<Task> getAllTaskListByUserId(Long userId){
        return taskRepository.findByUserId(userId);
    }
    public void deletedByTaskId(Long taskId){
        taskRepository.deleteById(taskId);
    }

}
