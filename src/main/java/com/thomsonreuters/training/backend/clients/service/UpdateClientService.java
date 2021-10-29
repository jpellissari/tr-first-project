package com.thomsonreuters.training.backend.clients.service;

import java.util.Optional;
import com.thomsonreuters.training.backend.clients.entity.Client;
import com.thomsonreuters.training.backend.clients.exception.ClientNotFoundException;
import com.thomsonreuters.training.backend.clients.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateClientService {
  @Autowired private ClientRepository clientRepository;

  public void execute(Client client) {
    Optional<Client> findClient = this.clientRepository.findById(client.getIdentifier());
    if (findClient.isEmpty()) {
      throw new ClientNotFoundException();
    }

    this.clientRepository.save(client);
  }
}
