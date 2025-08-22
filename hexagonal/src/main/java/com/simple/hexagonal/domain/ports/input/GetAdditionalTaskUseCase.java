package com.simple.hexagonal.domain.ports.input;

import com.simple.hexagonal.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo (Long id);
}
