package com.example.ninh.service;

import com.example.ninh.entity.HumanEntity;

import java.util.List;
import java.util.Optional;

public interface HumanService {
    List<HumanEntity> getAllHuman();
    Optional<HumanEntity> findById(Integer id);
    HumanEntity save(HumanEntity human);
    public void deleteById(Integer id);
}
