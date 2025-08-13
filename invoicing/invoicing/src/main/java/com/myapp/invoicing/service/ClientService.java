package com.myapp.invoicing.service;

import com.myapp.invoicing.dto.ClientDTO;
import com.myapp.invoicing.entity.Client;
import com.myapp.invoicing.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        client.setPhone(clientDTO.getPhone());
        Client saved = clientRepository.save(client);
        return toDTO(saved);
    }

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO getClientById(Long id) {
        return clientRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    private ClientDTO toDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setEmail(client.getEmail());
        dto.setPhone(client.getPhone());
        return dto;
    }
}
