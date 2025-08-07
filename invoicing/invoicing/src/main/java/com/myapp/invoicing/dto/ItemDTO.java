package com.myapp.invoicing.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {

    private Long id;
    private String description;
    private Integer quantity;
    private Double unitPrice;
    private Double total;
}
