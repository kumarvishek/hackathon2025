package com.squadseven.timesheet.model;

import lombok.Data;

@Data
public class SubmitTimesheetRequest {
    private Long timesheetId;
    private Long contractorId;
}