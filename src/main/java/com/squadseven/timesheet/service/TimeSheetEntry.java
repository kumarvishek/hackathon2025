package com.squadseven.timesheet.service;

import com.squadseven.timesheet.model.TimeSheetEntryModel;

import java.util.Optional;

public interface TimeSheetEntry {
    Optional<TimeSheetEntryModel> getContactorIdByEntryId(Integer EntryId);
}
