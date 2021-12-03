package com.thomsonreuters.training.backend.model.leavetypes;

import com.thomsonreuters.training.backend.model.leavetypes.types.ContributorsDeath;
import com.thomsonreuters.training.backend.model.leavetypes.types.MaternityLeave;
import com.thomsonreuters.training.backend.model.leavetypes.types.Others;
import com.thomsonreuters.training.backend.model.leavetypes.types.PaternityLeave;
import com.thomsonreuters.training.backend.model.leavetypes.types.Termination;
import com.thomsonreuters.training.backend.model.leavetypes.types.Vacation;
import com.thomsonreuters.training.backend.model.leavetypes.types.WorkInjury;

public enum LeaveTypes {
  CONTRIBUTORS_DEATH {
    public LeaveType getInstance(Integer numberOfDays) {
      return new ContributorsDeath();
    }
  },
  MATERNITY_LEAVE {
    public LeaveType getInstance(Integer numberOfDays) {
      return new MaternityLeave();
    }
  },
  PATERNITY_LEAVE {
    public LeaveType getInstance(Integer numberOfDays) {
      return new PaternityLeave();
    }
  },
  WORK_INJURY {
    public LeaveType getInstance(Integer numberOfDays) {
      return new WorkInjury();
    }
  },
  VACATION {
    public LeaveType getInstance(Integer numberOfDays) {
      return new Vacation(numberOfDays);
    }
  },
  TERMINATION {
    public LeaveType getInstance(Integer numberOfDays) {
      return new Termination();
    }
  },
  OTHERS {
    public LeaveType getInstance(Integer numberOfDays) {
      return new Others();
    }
  };

  public abstract LeaveType getInstance(Integer numberOfDays);
}
