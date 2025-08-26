package com.simple.hexagonal.infrastructure.config;

import com.simple.hexagonal.application.services.TaskService;
import com.simple.hexagonal.application.usecases.*;
import com.simple.hexagonal.domain.ports.input.GetAdditionalTaskUseCase;
import com.simple.hexagonal.domain.ports.output.ExternalServicePort;
import com.simple.hexagonal.domain.ports.output.TaskRepositoryPort;
import com.simple.hexagonal.infrastructure.adapters.ExternalServiceAdapter;
import com.simple.hexagonal.infrastructure.repositories.JpaTaskRepository;
import com.simple.hexagonal.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskUseCase getAdditionalTaskUseCase){
        return new TaskService(
                new CreateTaskUseCaseImp(taskRepositoryPort),
                new RetrieveTaskUseCaseImp(taskRepositoryPort),
                new UpdateTaskUseCaseImp(taskRepositoryPort),
                new DeleteTaskUseCaseImp(taskRepositoryPort),
                getAdditionalTaskUseCase
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter){
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskUseCase getAdditionalTaskUseCase(ExternalServicePort externalServicePort){
        return new GetAdditionalTaskUseCaseImp(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAdapter();
    }
}
