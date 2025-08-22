package com.simple.hexagonal.domain.ports.input;

import com.simple.hexagonal.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {

    Optional<Task> updateTask (Long id, Task updateTask);
}
