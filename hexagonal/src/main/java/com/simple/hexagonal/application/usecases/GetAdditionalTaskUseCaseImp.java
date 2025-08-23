package com.simple.hexagonal.application.usecases;

import com.simple.hexagonal.domain.models.AdditionalTaskInfo;
import com.simple.hexagonal.domain.ports.input.GetAdditionalTaskUseCase;
import com.simple.hexagonal.domain.ports.output.ExternalServicePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAdditionalTaskUseCaseImp implements GetAdditionalTaskUseCase {

    private final ExternalServicePort externalServicePort;


    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }
}
