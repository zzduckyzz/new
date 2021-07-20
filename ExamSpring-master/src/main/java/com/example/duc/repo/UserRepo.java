package com.example.duc.repo;

import com.example.duc.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {
    UserEntity findUserEntityByUsername(String username);
}
