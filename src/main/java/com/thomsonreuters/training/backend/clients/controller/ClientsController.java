package com.thomsonreuters.training.backend.clients.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.validation.Valid;
import com.thomsonreuters.training.backend.clients.dto.ClientDTO;
import com.thomsonreuters.training.backend.clients.dto.CreateClientDTO;
import com.thomsonreuters.training.backend.clients.dto.UpdateClientDTO;
import com.thomsonreuters.training.backend.clients.entity.Client;
import com.thomsonreuters.training.backend.clients.mapper.ClientMapper;
import com.thomsonreuters.training.backend.clients.mapper.CreateClientMapper;
import com.thomsonreuters.training.backend.clients.mapper.UpdateClientMapper;
import com.thomsonreuters.training.backend.clients.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clients")
public class ClientsController {
  @Autowired private ClientsService clientsService;

  @Autowired private ClientMapper clientMapper;
  @Autowired private CreateClientMapper createClientMapper;
  @Autowired private UpdateClientMapper updateClientMapper;

  @GetMapping
  public List<ClientDTO> index() {
    List<Client> clients = clientsService.getAll();

    return clients.stream().map(client -> clientMapper.toDto(client)).collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public ClientDTO get(@PathVariable String id) {
    Client client = clientsService.get(UUID.fromString(id));

    return clientMapper.toDto(client);
  }

  @PostMapping
  public ResponseEntity<Object> create(
      @RequestBody @Valid CreateClientDTO data, UriComponentsBuilder uriComponentsBuilder) {
    Client client = clientsService.create(createClientMapper.toEntity(data));

    URI uri =
        uriComponentsBuilder.path("/clients/{id}").buildAndExpand(client.getIdentifier()).toUri();

    return ResponseEntity.created(uri).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> update(
      @PathVariable String id, @RequestBody @Valid UpdateClientDTO data) {
    data.setId(id);
    Client client = clientsService.update(updateClientMapper.toEntity(data));

    return ResponseEntity.ok(client);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable String id) {
    clientsService.delete(UUID.fromString(id));

    return ResponseEntity.status(204).build();
  }
}
