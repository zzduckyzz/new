package com.example.ninh.repo;

import com.example.ninh.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {
    UserEntity findUserEntityByUsername(String username);
}
