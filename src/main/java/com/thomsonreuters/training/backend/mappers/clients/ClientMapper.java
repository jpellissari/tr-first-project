package com.thomsonreuters.training.backend.mappers.clients;

import java.util.UUID;
import com.thomsonreuters.training.backend.dtos.clients.ClientDTO;
import com.thomsonreuters.training.backend.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

  public ClientDTO toDto(Client client) {
    return new ClientDTO(client.getIdentifier().toString(), client.getName());
  }

  public Client toEntity(ClientDTO clientDto) {
    UUID uuid = UUID.fromString(clientDto.getId());
    return new Client(uuid, clientDto.getName());
  }
}
