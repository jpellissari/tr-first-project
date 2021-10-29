package com.thomsonreuters.training.backend.clients.controller;

import java.util.ArrayList;
import java.util.List;
import com.thomsonreuters.training.backend.clients.dto.ClientDTO;
import com.thomsonreuters.training.backend.clients.entity.Client;
import com.thomsonreuters.training.backend.clients.mapper.ClientMapper;
import com.thomsonreuters.training.backend.clients.service.FindAllClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindAllClientController {
  @Autowired private FindAllClientService findAllClientService;
  @Autowired private ClientMapper clientMapper;

  @GetMapping("/clients")
  public ResponseEntity<List<ClientDTO>> handle() {
    List<Client> clients = findAllClientService.execute();

    List<ClientDTO> clientsDto = new ArrayList<>();
    for (Client client : clients) {
      clientsDto.add(clientMapper.toDto(client));
    }

    return ResponseEntity.ok().body(clientsDto);
  }
}
