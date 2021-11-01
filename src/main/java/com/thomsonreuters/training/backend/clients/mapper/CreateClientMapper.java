package com.thomsonreuters.training.backend.clients.mapper;

import com.thomsonreuters.training.backend.clients.dto.CreateClientDTO;
import com.thomsonreuters.training.backend.clients.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class CreateClientMapper {
  public Client toEntity(CreateClientDTO data) {
    return new Client(data.getName());
  }
}
