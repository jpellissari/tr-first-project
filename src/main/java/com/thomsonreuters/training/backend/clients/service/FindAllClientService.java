package com.thomsonreuters.training.backend.clients.service;

import java.util.List;
import com.thomsonreuters.training.backend.clients.entity.Client;
import com.thomsonreuters.training.backend.clients.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindAllClientService {
  @Autowired private ClientRepository clientRepository;

  public List<Client> execute() {
    return this.clientRepository.findAll();
  }
}
