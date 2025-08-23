package com.simple.hexagonal.application.usecases;

import com.simple.hexagonal.domain.ports.input.DeleteTaskUseCase;
import com.simple.hexagonal.domain.ports.output.TaskRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteTaskUseCaseImp implements DeleteTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public boolean deleteTask(Long id) {
        return taskRepositoryPort.deleteById(id);

    }
}
