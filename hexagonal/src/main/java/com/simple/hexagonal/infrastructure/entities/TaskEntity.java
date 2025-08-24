package com.simple.hexagonal.infrastructure.entities;

import com.simple.hexagonal.domain.models.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private boolean completed;

    public static TaskEntity fromDomainModel(Task task){
        return new TaskEntity( task.getId(), task.getTitle(), task.getDescription(),task.getCreationDate(),task.isCompleted());
    }

    public Task toDomainModel(){
        return new Task(id,title,description,creationDate,completed);
    }
}
