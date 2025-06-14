package com.squadseven.timesheet.controller;

import com.squadseven.timesheet.model.TimeSheetEntryModel;
import com.squadseven.timesheet.service.TimeSheetEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/tse")
public class TimeSheetEntryController {

    @Autowired
    private TimeSheetEntry timeSheetEntry;

    @GetMapping("/getTimeSheetId/{TMSId}")
    public Optional<TimeSheetEntryModel> getContractorIdByEntryId(@PathVariable Integer TMSId){
        return timeSheetEntry.getContactorIdByEntryId(TMSId);
    }
}
