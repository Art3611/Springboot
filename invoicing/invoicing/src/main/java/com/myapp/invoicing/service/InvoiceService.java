package com.myapp.invoicing.service;

import com.myapp.invoicing.dto.InvoiceDTO;
import com.myapp.invoicing.dto.ItemDTO;
import com.myapp.invoicing.entity.Client;
import com.myapp.invoicing.entity.Invoice;
import com.myapp.invoicing.entity.Item;
import com.myapp.invoicing.entity.User;
import com.myapp.invoicing.repository.ClientRepository;
import com.myapp.invoicing.repository.InvoiceRepository;
import com.myapp.invoicing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ClientRepository clientRepository;
    private final UserRepository userRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository,
                          ClientRepository clientRepository,
                          UserRepository userRepository) {
        this.invoiceRepository = invoiceRepository;
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
    }

    public InvoiceDTO createInvoice(InvoiceDTO invoiceDTO) {
        Client client = clientRepository.findById(invoiceDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        User user = userRepository.findById(invoiceDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Invoice invoice = new Invoice();
        invoice.setDate(invoiceDTO.getDate());
        invoice.setDate(invoiceDTO.getDate());
        invoice.setClient(client);
        invoice.setUser(user);

        List<Item> items = invoiceDTO.getItems().stream().map(itemDTO -> {
            Item item = new Item();
            item.setDescription(itemDTO.getDescription());
            item.setQuantity(itemDTO.getQuantity());
            item.setUnitPrice(itemDTO.getUnitPrice());
            item.setInvoice(invoice);
            return item;
        }).collect(Collectors.toList());

        invoice.setItems(items);

        Invoice saved = invoiceRepository.save(invoice);
        return toDTO(saved);
    }

    public List<InvoiceDTO> getAllInvoices() {
        return invoiceRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public InvoiceDTO getInvoiceById(Long id) {
        return invoiceRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
    }

    public List<InvoiceDTO> getInvoicesByClientId(Long clientId) {
        return invoiceRepository.findByClientId(clientId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    private InvoiceDTO toDTO(Invoice invoice) {
        InvoiceDTO dto = new InvoiceDTO();
        dto.setId(invoice.getId());
        dto.setDate(invoice.getDate());
        dto.setTotal(invoice.getTotal());
        dto.setClientId(invoice.getClient().getId());
        dto.setUserId(invoice.getUser().getId());
        dto.setItems(invoice.getItems().stream().map(item -> {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setId(item.getId());
            itemDTO.setDescription(item.getDescription());
            itemDTO.setQuantity(item.getQuantity());
            itemDTO.setUnitPrice(item.getUnitPrice());
            return itemDTO;
        }).collect(Collectors.toList()));
        return dto;
    }
}
