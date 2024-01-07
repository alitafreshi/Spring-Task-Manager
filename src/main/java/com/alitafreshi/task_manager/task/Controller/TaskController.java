package com.alitafreshi.task_manager.task.Controller;

import com.alitafreshi.task_manager.task.model.Task;
import com.alitafreshi.task_manager.task.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/newTask")
    public Task insertNewTask(@RequestBody Task newTask) {
        return taskService.insertNewTask(newTask);
    }

    @GetMapping("/taskList/{userId}")
    public List<Task> getAllTasksByUserId(@PathVariable("userId") Long userId) {
        return taskService.getAllTaskListByUserId(userId);
    }

    @DeleteMapping("/deleteTask/{taskId}")
    public String removeTaskById(@PathVariable("taskId") Long taskId){
        return taskService.deletedByTaskId(taskId);
    }
}
