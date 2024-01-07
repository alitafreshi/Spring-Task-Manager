package com.alitafreshi.task_manager.user.model;

import com.alitafreshi.task_manager.task.model.Task;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "user_phone_number", nullable = false, columnDefinition = "TEXT")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole role;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<Task> taskList;
}