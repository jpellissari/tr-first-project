package com.thomsonreuters.training.backend.mappers.clients;

import java.util.UUID;
import com.thomsonreuters.training.backend.dtos.clients.UpdateClientDTO;
import com.thomsonreuters.training.backend.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class UpdateClientMapper {
  public Client toEntity(UpdateClientDTO data) {
    return new Client(UUID.fromString(data.getId()), data.getName());
  }
}
