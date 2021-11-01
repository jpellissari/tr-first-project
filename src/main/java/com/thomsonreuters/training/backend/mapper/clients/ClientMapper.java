package com.thomsonreuters.training.backend.mapper.clients;

import java.util.UUID;
import com.thomsonreuters.training.backend.dto.clients.ClientDTO;
import com.thomsonreuters.training.backend.model.Client;
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
