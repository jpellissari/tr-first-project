package com.thomsonreuters.training.backend.dto.employees;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.thomsonreuters.training.backend.validators.AnyOf;
import com.thomsonreuters.training.backend.validators.Date;
import com.thomsonreuters.training.backend.validators.UUID;
import br.com.caelum.stella.bean.validation.CPF;
import jdk.jfr.BooleanFlag;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class UpdateEmployeeDTO {
  @NotEmpty @UUID private String clientId;
  @NotEmpty @UUID private String jobPositionId;

  @NotEmpty
  @Length(max = 50)
  private String name;

  @NotEmpty
  @Date(pattern = "dd/MM/yyyy")
  private String birthdate;

  @NotEmpty @CPF private String nationalIdentity;

  @NotNull
  @NumberFormat(style = Style.CURRENCY)
  private double salary;

  @NotNull @BooleanFlag private boolean active;

  @NotEmpty
  @AnyOf({"intern", "employee", "partner"})
  private String type;

  public String getClientId() {
    return clientId;
  }

  public String getJobPositionId() {
    return jobPositionId;
  }

  public String getName() {
    return name;
  }

  public boolean isActive() {
    return active;
  }

  public String getNationalIdentity() {
    return nationalIdentity;
  }

  public String getBirthdate() {
    return birthdate;
  }

  public double getSalary() {
    return salary;
  }

  public String getType() {
    return type;
  }
}
