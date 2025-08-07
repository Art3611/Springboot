package com.myapp.invoicing.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer quantity;
    private Double unitPrice;

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    @JsonManagedReference
    private Invoice invoice;

    public Double getTotal() {
        return quantity * unitPrice;
    }
}