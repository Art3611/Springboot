package com.myapp.invoicing.service;

import com.myapp.invoicing.entity.Invoice;
import com.myapp.invoicing.entity.Item;
import com.myapp.invoicing.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice createInvoice(Invoice invoice) {
        if (invoice.getItems() != null) {
            for (Item item : invoice.getItems()) {
                item.setInvoice(invoice);
            }
        }
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> getInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }

    public List<Invoice> getInvoicesByClientId(Long clientId) {
        return invoiceRepository.findByClientId(clientId);
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}