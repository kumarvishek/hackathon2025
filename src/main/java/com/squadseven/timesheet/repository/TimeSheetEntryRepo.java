package com.squadseven.timesheet.repository;

import com.squadseven.timesheet.model.TimeSheetEntryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSheetEntryRepo extends JpaRepository<TimeSheetEntryModel, Integer> {
}
