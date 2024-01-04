package com.alitafreshi.task_manager.user.repository;

import com.alitafreshi.task_manager.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByPhoneNumber(String PhoneNumber);
}
