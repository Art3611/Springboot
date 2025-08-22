package com.simple.hexagonal.domain.ports.input;

import com.simple.hexagonal.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {
    Optional<Task> getTask (Long id);
    List<Task> getAllTasks ();
}
