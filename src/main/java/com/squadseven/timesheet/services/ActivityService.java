package com.squadseven.timesheet.services;

import com.squadseven.timesheet.model.Activity;
import com.squadseven.timesheet.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getAllActivityTypes() {
        return activityRepository.findAll();
    }

    public Activity getActivityTypeById(Long id) {
        return activityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ActivityType not found with ID: " + id));
    }

    public Activity createActivity(Activity activity) {
        if (activityRepository.findByName(activity.getName()).isPresent()) {
            throw new IllegalArgumentException("ActivityType with this name already exists.");
        }
        return activityRepository.save(activity);
    }

    public Activity updateActivityType(Long id, Activity updated) {
        Activity existing = getActivityTypeById(id);
        existing.setName(updated.getName());
        return activityRepository.save(existing);
    }

}



