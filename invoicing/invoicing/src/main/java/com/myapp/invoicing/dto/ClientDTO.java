package com.myapp.invoicing.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name can´t be more than 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @Size(max = 15, message = "Maximum number is 15")
    private String phone;

    private Long userId;
}
