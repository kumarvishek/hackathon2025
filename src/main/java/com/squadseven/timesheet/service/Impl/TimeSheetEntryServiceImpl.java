package com.squadseven.timesheet.service.Impl;

import com.squadseven.timesheet.repository.TimeSheetEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimeSheetEntryService {

    @Autowired
    private TimeSheetEntryRepo tseRepo;

    public Optional<TimeSheetEntryRepo> getContactorIdByEntryId(Integer EntryId){
        return tseRepo.findById(EntryId);
    }
}
