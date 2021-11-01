package com.thomsonreuters.training.backend.repositories;

import java.util.UUID;
import com.thomsonreuters.training.backend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, UUID> {}
