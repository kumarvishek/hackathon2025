package com.squadseven.timesheet.controller;

import com.squadseven.timesheet.model.Activity;
import com.squadseven.timesheet.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-types")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public List<Activity> getAll() {
        return activityService.getAllActivitys();
    }

    @GetMapping("/{id}")
    public Activity getById(@PathVariable Long id) {
        return activityService.getActivityById(id);
    }

    @PostMapping
    public Activity create(@RequestBody Activity Activity) {
        return activityService.createActivity(Activity);
    }

    @PutMapping("/{id}")
    public Activity update(@PathVariable Long id, @RequestBody Activity Activity) {
        return activityService.updateActivity(id, Activity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        activityService.deleteActivity(id);
        return ResponseEntity.noContent().build();
    }
}
