package com.thomsonreuters.training.backend.repository;

import java.util.Optional;
import java.util.UUID;
import com.thomsonreuters.training.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employee, UUID> {
  //  @Query("select e from Employee e where e.nationalIdentity = ?1 and e.client.identifier = ?2")
  Optional<Employee> findByNationalIdentityAndClientIdentifier(
      String nationalIdentity, UUID clientId);
}
