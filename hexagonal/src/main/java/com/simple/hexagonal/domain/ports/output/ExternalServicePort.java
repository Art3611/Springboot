package com.simple.hexagonal.domain.ports.output;

import com.simple.hexagonal.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
