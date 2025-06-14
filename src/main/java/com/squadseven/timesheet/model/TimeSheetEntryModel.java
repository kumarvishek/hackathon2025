package com.squadseven.timesheet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
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

    public Integer getEntryId() {
        return EntryId;
    }

    public void setEntryId(Integer entryId) {
        EntryId = entryId;
    }

    public Integer getContractorId() {
        return ContractorId;
    }

    public void setContractorId(Integer contractorId) {
        ContractorId = contractorId;
    }

    public Integer getProjectCode() {
        return ProjectCode;
    }

    public void setProjectCode(Integer projectCode) {
        ProjectCode = projectCode;
    }

    public Integer getActivityCode() {
        return ActivityCode;
    }

    public void setActivityCode(Integer activityCode) {
        ActivityCode = activityCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getHoursWorked() {
        return HoursWorked;
    }

    public void setHoursWorked(Integer hoursWorked) {
        HoursWorked = hoursWorked;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }
}
