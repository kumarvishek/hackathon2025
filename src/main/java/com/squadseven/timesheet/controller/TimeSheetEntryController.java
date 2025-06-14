package com.squadseven.timesheet.controller;

import com.squadseven.timesheet.model.TimeSheetEntryModel;
import com.squadseven.timesheet.service.TimeSheetEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/tse")
public class TimeSheetEntryController {

    @Autowired
    private TimeSheetEntry timeSheetEntry;

    @GetMapping("/timeSheetId/{TMSId}")
    public Optional<TimeSheetEntryModel> getContractorIdByEntryId(@PathVariable Integer TMSId){
        return timeSheetEntry.getContactorIdByEntryId(TMSId);
    }

//    @PostMapping("/timeSheetId/add")
//    public ResponseEntity<TimeSheetEntryModel> UploadTimeSheetEntry( TimeSheetEntryModel model1){
//        TimeSheetEntryModel savedData = TimeSheetEntry
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedData);
//    }
}
