package com.myapp.invoicing.controller;

import com.myapp.invoicing.dto.InvoiceDTO;
import com.myapp.invoicing.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public InvoiceDTO createInvoice(@Valid @RequestBody InvoiceDTO invoiceDTO) {
        return invoiceService.createInvoice(invoiceDTO);
    }

    @GetMapping
    public List<InvoiceDTO> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/{id}")
    public InvoiceDTO getInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id);
    }

    @GetMapping("/client/{clientId}")
    public List<InvoiceDTO> getInvoicesByClientId(@PathVariable Long clientId) {
        return invoiceService.getInvoicesByClientId(clientId);
    }

    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
    }
}
