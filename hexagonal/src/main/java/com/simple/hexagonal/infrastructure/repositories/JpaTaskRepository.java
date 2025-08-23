package com.simple.hexagonal.infrastructure.repositories;

import com.simple.hexagonal.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTaskRepository extends JpaRepository<TaskEntity,Long> {
}
