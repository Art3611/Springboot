package com.simple.hexagonal.application.services;

import com.simple.hexagonal.domain.models.AdditionalTaskInfo;
import com.simple.hexagonal.domain.models.Task;
import com.simple.hexagonal.domain.ports.input.*;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class TaskService implements CreateTaskUseCase, DeleteTaskUseCase, RetrieveTaskUseCase, UpdateTaskUseCase, GetAdditionalTaskUseCase {

    private final CreateTaskUseCase createTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetAdditionalTaskUseCase getAdditionalTaskUseCase;


    @Override
    public Task createTask(Task task) {
        return  createTaskUseCase.createTask(task);
    }

    @Override
    public boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return getAdditionalTaskUseCase.getAdditionalTaskInfo(id);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return retrieveTaskUseCase.getTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return updateTaskUseCase.updateTask(id , updateTask);
    }
}
