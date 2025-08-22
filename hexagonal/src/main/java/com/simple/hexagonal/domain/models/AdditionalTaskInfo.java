package com.simple.hexagonal.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
public class AdditionalTaskInfo {

    private final Long userId;
    private final String userName;
    private final String userEmail;
}
