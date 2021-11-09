package com.thomsonreuters.training.backend.dto.employees;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import com.thomsonreuters.training.backend.validators.AnyOf;
import com.thomsonreuters.training.backend.validators.Date;
import com.thomsonreuters.training.backend.validators.RequireIfAnotherFieldIs;
import com.thomsonreuters.training.backend.validators.UUID;

@RequireIfAnotherFieldIs(require = "type", when = "leaveType", is = "work_injury")
public class CreateEmployeeLeaveDTO {
  @NotEmpty @UUID private String clientId;
  @NotEmpty @UUID private String employeeId;

  @NotEmpty
  @AnyOf({
    "contributors_death",
    "maternity_leave",
    "paternity_leave",
    "work_injury",
    "vacation",
    "termination",
    "others"
  })
  private String leaveType;

  @NotEmpty
  @Date(pattern = "dd/MM/yyyy")
  private String leaveDate;

  @Min(value = 0)
  private Integer numberDays;

  @AnyOf({"typical", "professional_disease", "commuting_accident"})
  private String type;

  public String getClientId() {
    return clientId;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public String getLeaveType() {
    return leaveType;
  }

  public String getLeaveDate() {
    return leaveDate;
  }

  public Integer getNumberDays() {
    return numberDays;
  }

  public String getType() {
    return type;
  }
}
