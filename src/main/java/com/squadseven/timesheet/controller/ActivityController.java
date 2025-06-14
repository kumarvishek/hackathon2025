package com.squadseven.timesheet.controller;

import com.squadseven.timesheet.model.Activity;
import com.squadseven.timesheet.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public List<Activity> getAll() {
        return activityService.getAllActivities();
    }


    @PostMapping
    public Activity create(@RequestBody Activity Activity) {
        return activityService.createActivity(Activity);
    }

}
