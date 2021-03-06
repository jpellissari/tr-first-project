package com.thomsonreuters.training.backend.repository;

import java.util.UUID;
import com.thomsonreuters.training.backend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Client, UUID> {}
