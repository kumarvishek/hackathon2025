package com.squadseven.timesheet.service.Impl;

import com.squadseven.timesheet.repository.TimeSheetEntryRepo;
import com.squadseven.timesheet.model.TimeSheetEntryModel;
import com.squadseven.timesheet.service.TimeSheetEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TimeSheetEntryServiceImpl implements TimeSheetEntry {

    @Autowired
    private TimeSheetEntryRepo tseRepo;

    public Optional<TimeSheetEntryModel> getContactorIdByEntryId(Integer EntryId){
        return tseRepo.findById(EntryId);
    }


}
