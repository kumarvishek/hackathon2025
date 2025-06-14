package com.squadseven.timesheet.service;

import com.squadseven.timesheet.model.Activity;
import com.squadseven.timesheet.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }


    public Activity createActivity(Activity activity) {
        if (activityRepository.findByName(activity.getName()).isPresent()) {
            throw new IllegalArgumentException("ActivityType with this name already exists.");
        }
        return activityRepository.save(activity);
    }

}



