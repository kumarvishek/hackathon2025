package com.squadseven.timesheet.controller;

import com.squadseven.timesheet.model.Activity;
import com.squadseven.timesheet.model.SubmitTimesheetRequest;
import com.squadseven.timesheet.model.Timesheet;
import com.squadseven.timesheet.model.User;
import com.squadseven.timesheet.service.TimesheetService;
import com.squadseven.timesheet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.squadseven.timesheet.util.Constants.DRAFT;

@RestController
@RequestMapping("/timesheet")
public class TimesheetController {

    @Autowired
    private TimesheetService timesheetService;

    // Get all the timesheet
    @GetMapping
    public List<Timesheet> getAllTimeSheet() {
        return timesheetService.getAllTimesheet();
    }

    // Insert initial timesheet entry
    @PostMapping
    public Timesheet create(@RequestBody Timesheet timesheet) {
        return timesheetService.createTimesheet(timesheet);
    }



}