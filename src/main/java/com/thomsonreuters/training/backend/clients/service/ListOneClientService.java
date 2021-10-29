package com.thomsonreuters.training.backend.clients.service;

import java.util.UUID;
import com.thomsonreuters.training.backend.clients.entity.Client;
import com.thomsonreuters.training.backend.clients.exception.ClientNotFoundException;
import com.thomsonreuters.training.backend.clients.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListOneClientService {
  @Autowired private ClientRepository clientRepository;

  public Client execute(UUID id) throws ClientNotFoundException {
    return this.clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
  }
}
