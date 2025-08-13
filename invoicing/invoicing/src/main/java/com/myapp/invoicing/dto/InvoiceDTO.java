package com.myapp.invoicing.dto;

import com.myapp.invoicing.entity.Invoice;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class InvoiceDTO {

    private Long id;

    @NotNull(message = "Date is required")
    @PastOrPresent(message = "Date cannot be in the future")
    private LocalDate date;

    private Double total; // se calcula en backend, no se valida en entrada

    @NotNull(message = "Client ID is required")
    private Long clientId;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotEmpty(message = "Invoice must have at least one item")
    @Valid
    private List<ItemDTO> items;

    public InvoiceDTO convertToDTO(Invoice invoice) {
        InvoiceDTO dto = new InvoiceDTO();
        dto.setId(invoice.getId());
        dto.setDate(invoice.getDate());
        dto.setTotal(invoice.getTotal());
        dto.setClientId(invoice.getClient().getId());
        dto.setUserId(invoice.getUser().getId());

        List<ItemDTO> itemsDTO = invoice.getItems().stream().map(item -> {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setId(item.getId());
            itemDTO.setDescription(item.getDescription());
            itemDTO.setQuantity(item.getQuantity());
            itemDTO.setUnitPrice(item.getUnitPrice());
            itemDTO.setTotal(item.getTotal());
            return itemDTO;
        }).toList();

        dto.setItems(itemsDTO);
        return dto;
    }
}