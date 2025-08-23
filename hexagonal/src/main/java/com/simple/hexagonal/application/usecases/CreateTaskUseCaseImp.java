package com.simple.hexagonal.application.usecases;

import com.simple.hexagonal.domain.models.Task;
import com.simple.hexagonal.domain.ports.input.CreateTaskUseCase;
import com.simple.hexagonal.domain.ports.output.TaskRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateTaskUseCaseImp implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
