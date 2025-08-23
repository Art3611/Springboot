package com.simple.hexagonal.infrastructure.repositories;

import com.simple.hexagonal.domain.models.Task;
import com.simple.hexagonal.domain.ports.output.TaskRepositoryPort;
import com.simple.hexagonal.infrastructure.entities.TaskEntity;

import java.util.List;
import java.util.Optional;

public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    private final JpaTaskRepository jpaTaskRepository;

    public JpaTaskRepositoryAdapter(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskEntity
        return null;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> findAll() {
        return List.of();
    }

    @Override
    public Optional<Task> update(Task task) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
