package com.simple.hexagonal.application.usecases;

import com.simple.hexagonal.domain.models.Task;
import com.simple.hexagonal.domain.ports.input.UpdateTaskUseCase;
import com.simple.hexagonal.domain.ports.output.TaskRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UpdateTaskUseCaseImp implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return taskRepositoryPort.update(updateTask);
    }
}
