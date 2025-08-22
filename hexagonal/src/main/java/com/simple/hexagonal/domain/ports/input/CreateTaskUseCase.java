package com.simple.hexagonal.domain.ports.input;

import com.simple.hexagonal.domain.models.Task;

public interface CreateTaskUseCase {

    Task createTask (Task task);
}
