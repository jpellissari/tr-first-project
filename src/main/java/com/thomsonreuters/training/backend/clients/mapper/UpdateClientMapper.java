package com.thomsonreuters.training.backend.clients.mapper;

import java.util.UUID;
import com.thomsonreuters.training.backend.clients.dto.UpdateClientDTO;
import com.thomsonreuters.training.backend.clients.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class UpdateClientMapper {
  public Client toEntity(UpdateClientDTO data) {
    return new Client(UUID.fromString(data.getId()), data.getName());
  }
}
