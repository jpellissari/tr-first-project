package com.thomsonreuters.training.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.thomsonreuters.training.backend.exception.ClientNotFoundException;
import com.thomsonreuters.training.backend.model.Client;
import com.thomsonreuters.training.backend.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {
  @Autowired private ClientsRepository clientsRepository;

  public List<Client> getAll() {
    return this.clientsRepository.findAll();
  }

  public Client get(UUID id) throws ClientNotFoundException {
    return this.clientsRepository.findById(id).orElseThrow(ClientNotFoundException::new);
  }

  public Client create(Client client) {
    return this.clientsRepository.save(client);
  }

  public Client update(Client client) {
    Optional<Client> findClient = this.clientsRepository.findById(client.getIdentifier());
    if (findClient.isEmpty()) {
      throw new ClientNotFoundException();
    }

    return this.clientsRepository.save(client);
  }

  public void delete(UUID id) throws ClientNotFoundException {
    Client client = this.clientsRepository.findById(id).orElseThrow(ClientNotFoundException::new);

    clientsRepository.delete(client);
  }
}
