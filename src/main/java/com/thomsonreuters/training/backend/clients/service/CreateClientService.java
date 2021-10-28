package com.thomsonreuters.training.backend.clients.service;

import com.thomsonreuters.training.backend.clients.entity.Client;
import com.thomsonreuters.training.backend.clients.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateClientService {
  @Autowired
  private ClientRepository clientRepository;

  public void execute(Client client) {
    this.clientRepository.save(client);
  }
}
