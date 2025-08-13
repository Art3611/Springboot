package com.myapp.invoicing.service;

import com.myapp.invoicing.dto.ItemDTO;
import com.myapp.invoicing.entity.Invoice;
import com.myapp.invoicing.entity.Item;
import com.myapp.invoicing.repository.InvoiceRepository;
import com.myapp.invoicing.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository, InvoiceRepository invoiceRepository) {
        this.itemRepository = itemRepository;
        this.invoiceRepository = invoiceRepository;
    }

    public ItemDTO createItem(ItemDTO itemDTO) {
        Invoice invoice = invoiceRepository.findById(itemDTO.getInvoiceId())
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));

        Item item = new Item();
        item.setDescription(itemDTO.getDescription());
        item.setQuantity(itemDTO.getQuantity());
        item.setUnitPrice(itemDTO.getUnitPrice());
        item.setInvoice(invoice);

        Item saved = itemRepository.save(item);
        return toDTO(saved);
    }

    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ItemDTO getItemById(Long id) {
        return itemRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Ítem no encontrado"));
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    private ItemDTO toDTO(Item item) {
        ItemDTO dto = new ItemDTO();
        dto.setId(item.getId());
        dto.setDescription(item.getDescription());
        dto.setQuantity(item.getQuantity());
        dto.setUnitPrice(item.getUnitPrice());
        dto.setInvoiceId(item.getInvoice().getId());
        return dto;
    }
}
