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
    "CONTRIBUTORS_DEATH",
    "MATERNITY_LEAVE",
    "PATERNITY_LEAVE",
    "WORK_INJURY",
    "VACATION",
    "TERMINATION",
    "OTHERS",
  })
  private String leaveType;

  @NotEmpty
  @Date(pattern = "dd/MM/yyyy")
  private String leaveDate;

  @Min(value = 0)
  private Integer numberDays;

  @AnyOf({"TYPICAL", "PROFESSIONAL_DISEASE", "COMMUTING-ACCIDENT"})
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
