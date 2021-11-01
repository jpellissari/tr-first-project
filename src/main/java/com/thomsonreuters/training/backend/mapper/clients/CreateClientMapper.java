package com.thomsonreuters.training.backend.mapper.clients;

import com.thomsonreuters.training.backend.dto.clients.CreateClientDTO;
import com.thomsonreuters.training.backend.model.Client;
import org.springframework.stereotype.Component;

@Component
public class CreateClientMapper {
  public Client toEntity(CreateClientDTO data) {
    return new Client(data.getName());
  }
}
