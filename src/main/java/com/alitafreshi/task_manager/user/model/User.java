package com.alitafreshi.task_manager.user.model;

import com.alitafreshi.task_manager.task.model.Task;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "tbl_user", uniqueConstraints = {
        @UniqueConstraint(name = "user_id_unique", columnNames = "user_id"),
        @UniqueConstraint(name = "user_phone_number_unique", columnNames = "user_phone_number")
})
@Entity
@Data
public class User {
    @Schema(description = "user id we will insert or find user with this param later on")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;

    @Schema(description = "user phone number we user this field to find user actions in the system like created task and etc")
    @Column(name = "user_phone_number", nullable = false, columnDefinition = "TEXT")
    private String phoneNumber;

    @Schema(description = "user role")
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole role;
    @Schema(description = "the list of tasks information that creates by the user")
    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<Task> taskList;
}