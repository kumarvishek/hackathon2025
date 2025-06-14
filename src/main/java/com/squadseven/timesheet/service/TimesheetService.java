package com.squadseven.timesheet.service;

import com.squadseven.timesheet.model.Project;
import com.squadseven.timesheet.model.Timesheet;
import com.squadseven.timesheet.model.User;
import com.squadseven.timesheet.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.squadseven.timesheet.util.Constants.DRAFT;

@Service
public class TimesheetService {

    @Autowired
    private TimesheetRepository timesheetRepository;

    public List<Timesheet> getAllTimesheet() {
        return timesheetRepository.findAll();
    }

    public Timesheet createTimesheet(Timesheet timesheet) {
        timesheet.setTotalHours(0);
        timesheet.setWeek_start(new Date());
        timesheet.setStatus(DRAFT);
        return timesheetRepository.save(timesheet);
    }

}