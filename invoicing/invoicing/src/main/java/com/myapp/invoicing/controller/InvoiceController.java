package com.myapp.invoicing.controller;


import com.myapp.invoicing.dto.InvoiceDTO;
import com.myapp.invoicing.entity.Client;
import com.myapp.invoicing.entity.Invoice;
import com.myapp.invoicing.entity.Item;
import com.myapp.invoicing.entity.User;
import com.myapp.invoicing.repository.ClientRepository;
import com.myapp.invoicing.repository.UserRepository;
import com.myapp.invoicing.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final ClientRepository clientRepository;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<InvoiceDTO> createInvoice(@RequestBody InvoiceDTO invoiceDTO) {

        Invoice invoice = new Invoice();
       //long pruebaid = invoice.getId();
        invoice.setDate(invoiceDTO.getDate());

        Client client = clientRepository.findById(invoiceDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        invoice.setClient(client);

        User user = userRepository.findById(invoiceDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
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


        Invoice savedInvoice = invoiceService.createInvoice(invoice);


        InvoiceDTO responseDTO = new InvoiceDTO().convertToDTO(savedInvoice);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public List<InvoiceDTO> getAllInvoices() {
        return invoiceService.getAllInvoices().stream()
                .map(invoice -> new InvoiceDTO().convertToDTO(invoice))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDTO> getInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id)
                .map(invoice -> ResponseEntity.ok(new InvoiceDTO().convertToDTO(invoice)))
                .orElse(ResponseEntity.notFound().build());
    }
}