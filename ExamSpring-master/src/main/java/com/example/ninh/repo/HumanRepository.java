package com.example.ninh.repo;

import com.example.ninh.entity.HumanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepository extends JpaRepository<HumanEntity, Integer> {
}
