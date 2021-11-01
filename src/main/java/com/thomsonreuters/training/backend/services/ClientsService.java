package com.thomsonreuters.training.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.thomsonreuters.training.backend.entities.Client;
import com.thomsonreuters.training.backend.exceptions.ClientNotFoundException;
import com.thomsonreuters.training.backend.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {
  @Autowired private ClientRepository clientRepository;

  public List<Client> getAll() {
    return this.clientRepository.findAll();
  }

  public Client get(UUID id) throws ClientNotFoundException {
    return this.clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
  }

  public Client create(Client client) {
    return this.clientRepository.save(client);
  }

  public Client update(Client client) {
    Optional<Client> findClient = this.clientRepository.findById(client.getIdentifier());
    if (findClient.isEmpty()) {
      throw new ClientNotFoundException();
    }

    return this.clientRepository.save(client);
  }

  public void delete(UUID id) throws ClientNotFoundException {
    Client client = this.clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);

    clientRepository.delete(client);
  }
}
