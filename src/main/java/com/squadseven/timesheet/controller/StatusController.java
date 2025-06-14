package com.squadseven.timesheet.controller;

import com.squadseven.timesheet.model.SubmitTimesheetRequest;
import com.squadseven.timesheet.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/submit")
public class StatusController {

    @Autowired
    private TimesheetService timesheetService;

    @PostMapping()
    public ResponseEntity<?> submitTimesheet(@RequestBody SubmitTimesheetRequest request) {
        String message = timesheetService.submitTimesheet(request.getTimesheetId(), request.getContractorId());
        return ResponseEntity.ok().body(Map.of("message", message));
    }
}
