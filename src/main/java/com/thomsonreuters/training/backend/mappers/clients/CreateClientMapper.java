package com.thomsonreuters.training.backend.mappers.clients;

import com.thomsonreuters.training.backend.dtos.clients.CreateClientDTO;
import com.thomsonreuters.training.backend.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class CreateClientMapper {
  public Client toEntity(CreateClientDTO data) {
    return new Client(data.getName());
  }
}
