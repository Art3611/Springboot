package com.myapp.invoicing.controller;

import com.myapp.invoicing.dto.ClientDTO;
import com.myapp.invoicing.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ClientDTO createClient(@Valid @RequestBody ClientDTO clientDTO) {
        return clientService.createClient(clientDTO);
    }

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/user/{userId}")
    public List<ClientDTO> getClientsByUserId(@PathVariable Long userId) {
        return clientService.getClientsByUserId(userId);
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
