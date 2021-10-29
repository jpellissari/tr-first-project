package com.thomsonreuters.training.backend.clients.mapper;

import java.util.UUID;
import com.thomsonreuters.training.backend.clients.dto.ClientDTO;
import com.thomsonreuters.training.backend.clients.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

  public ClientDTO toDto(Client client) {
    return new ClientDTO(client.getIdentifier().toString(), client.getName());
  }

  public Client toEntity(ClientDTO clientDto) {
    if (clientDto.getId() == null) {
      return new Client(clientDto.getName());
    }
    UUID uuid = UUID.fromString(clientDto.getId());
    return new Client(uuid, clientDto.getName());
  }
}
