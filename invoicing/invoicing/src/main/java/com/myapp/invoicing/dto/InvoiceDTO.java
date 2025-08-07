package com.myapp.invoicing.dto;

import com.myapp.invoicing.entity.Invoice;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class InvoiceDTO {

    private Long id;
    private LocalDate date;
    private Double total;
    private Long clientId;
    private Long userId;
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
        }).collect(Collectors.toList());

        dto.setItems(itemsDTO);
        return dto;
    }
}
