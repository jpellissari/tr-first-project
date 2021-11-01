package com.thomsonreuters.training.backend.mapper.clients;

import java.util.UUID;
import com.thomsonreuters.training.backend.dto.clients.UpdateClientDTO;
import com.thomsonreuters.training.backend.model.Client;
import org.springframework.stereotype.Component;

@Component
public class UpdateClientMapper {
  public Client toEntity(UpdateClientDTO data) {
    return new Client(UUID.fromString(data.getId()), data.getName());
  }
}
