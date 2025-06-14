package com.squadseven.timesheet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class TimeSheetEntryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer EntryId;
    private Integer ContractorId;
    private Integer ProjectCode;
    private Integer ActivityCode;
    private Date date;
    private Integer HoursWorked;
    private String Comments;

    public TimeSheetEntryModel(Integer entryId, Integer contractorId, Integer projectCode, Integer activityCode, Date date, Integer hoursWorked, String comments) {
        EntryId = entryId;
        ContractorId = contractorId;
        ProjectCode = projectCode;
        ActivityCode = activityCode;
        this.date = date;
        HoursWorked = hoursWorked;
        Comments = comments;
    }
}
