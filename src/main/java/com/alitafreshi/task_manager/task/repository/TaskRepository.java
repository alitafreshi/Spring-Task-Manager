package com.alitafreshi.task_manager.task.repository;

import com.alitafreshi.task_manager.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
