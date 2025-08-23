package com.simple.hexagonal.application.usecases;

import com.simple.hexagonal.domain.models.Task;
import com.simple.hexagonal.domain.ports.input.RetrieveTaskUseCase;
import com.simple.hexagonal.domain.ports.output.TaskRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class RetrieveTaskUseCaseImp implements RetrieveTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepositoryPort.findAll();
    }
}
