package com.thomsonreuters.training.backend.clients.controller;

import java.util.UUID;
import com.thomsonreuters.training.backend.clients.dto.ClientDTO;
import com.thomsonreuters.training.backend.clients.entity.Client;
import com.thomsonreuters.training.backend.clients.mapper.ClientMapper;
import com.thomsonreuters.training.backend.clients.service.ListOneClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListOneClientController {
  @Autowired
  private ListOneClientService listOneClientService;
  @Autowired
  private ClientMapper clientMapper;

  @GetMapping("/clients/{id}")
  public ClientDTO handle(@PathVariable String id) {
    UUID uuid = UUID.fromString(id);

    Client client = this.listOneClientService.execute(uuid);

    return clientMapper.toDto(client);
  }
}
