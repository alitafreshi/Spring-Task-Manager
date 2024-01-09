package com.alitafreshi.task_manager.task.Controller;

import com.alitafreshi.task_manager.task.model.Task;
import com.alitafreshi.task_manager.task.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@Tag(name="Task Apis")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/newTask")
    @Operation(summary = "insert new note into database")
    public Task insertNewTask(@RequestBody Task newTask) {
        return taskService.insertNewTask(newTask);
    }

    @GetMapping("/taskList/{userId}")
    @Operation(summary = "get all related notes for specific user by userId")
    public List<Task> getAllTasksByUserId(@PathVariable("userId") Long userId) {
        return taskService.getAllTaskListByUserId(userId);
    }

    @DeleteMapping("/deleteTask/{taskId}")
    @Operation(summary = "delete note from database")
    public String removeTaskById(@PathVariable("taskId") Long taskId){
        return taskService.deletedByTaskId(taskId);
    }
}
