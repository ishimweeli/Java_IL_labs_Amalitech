package com.amalitechRMS.repository;

import com.amalitechRMS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByEmail(String newEmail);
}

