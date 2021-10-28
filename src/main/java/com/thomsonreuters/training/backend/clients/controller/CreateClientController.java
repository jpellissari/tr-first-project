package com.thomsonreuters.training.backend.clients.controller;

import com.thomsonreuters.training.backend.clients.dto.ClientDTO;
import com.thomsonreuters.training.backend.clients.entity.Client;
import com.thomsonreuters.training.backend.clients.mapper.ClientMapper;
import com.thomsonreuters.training.backend.clients.service.CreateClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateClientController {
  @Autowired
  private CreateClientService createClientService;
  @Autowired
  private ClientMapper clientMapper;

  @PostMapping("/clients")
  public ResponseEntity<Object> handle(@RequestBody ClientDTO clientDto) {

    Client client = clientMapper.toEntity(clientDto);
    createClientService.execute(client);
    return ResponseEntity.status(201).build();
  }
}