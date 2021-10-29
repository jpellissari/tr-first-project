package com.thomsonreuters.training.backend.clients.controller;

import com.thomsonreuters.training.backend.clients.dto.ClientDTO;
import com.thomsonreuters.training.backend.clients.entity.Client;
import com.thomsonreuters.training.backend.clients.mapper.ClientMapper;
import com.thomsonreuters.training.backend.clients.service.UpdateClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateClientController {
  @Autowired private UpdateClientService updateClientService;
  @Autowired private ClientMapper clientMapper;

  @PutMapping("/clients/{id}")
  public ResponseEntity<Object> handle(@PathVariable String id, @RequestBody ClientDTO clientDto) {
    clientDto.setId(id);
    Client client = clientMapper.toEntity(clientDto);
    this.updateClientService.execute(client);

    return ResponseEntity.ok().build();
  }
}
