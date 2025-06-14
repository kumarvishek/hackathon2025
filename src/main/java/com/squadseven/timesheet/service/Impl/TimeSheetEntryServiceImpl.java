package com.squadseven.timesheet.service.Impl;

import com.squadseven.timesheet.repository.TimeSheetEntryRepo;
import com.squadseven.timesheet.model.TimeSheetEntryModel;
import com.squadseven.timesheet.service.TimeSheetEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TimeSheetEntryServiceImpl implements TimeSheetEntry {

    @Autowired
    private TimeSheetEntryRepo tseRepo;

    @Override
    public Optional<TimeSheetEntryModel> getContactorIdByEntryId(Integer EntryId){
        return tseRepo.findById(EntryId);
    }

    @Override
    public TimeSheetEntryModel addEntry(TimeSheetEntryModel tSEM) {
        return tseRepo.save(tSEM);
    }

    private List<TimeSheetEntryModel> getBookList(){
        return Arrays.asList(new TimeSheetEntryModel(1, 1, 214, 400, new Date(), 2, "Good" ),
                new TimeSheetEntryModel(1, 1, 214, 400, new Date(), 2, "Good" ),
                new TimeSheetEntryModel(1, 1, 214, 400, new Date(), 2, "Good" ),
                new TimeSheetEntryModel(1, 1, 214, 400, new Date(), 2, "Good" ),
                new TimeSheetEntryModel(1, 1, 214, 400, new Date(), 2, "Good" ),
                new TimeSheetEntryModel(1, 1, 214, 400, new Date(), 2, "Good" ));
    }


}
