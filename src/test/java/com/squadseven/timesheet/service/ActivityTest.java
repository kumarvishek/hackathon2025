package com.squadseven.timesheet.service;

import com.squadseven.timesheet.model.Activity;
import com.squadseven.timesheet.repository.ActivityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ActivityServiceTest {

    @Mock
    private ActivityRepository activityRepository;

    @InjectMocks
    private ActivityService activityService;

    @Test
    void getAllActivities_ReturnsAllActivities() {
        // Arrange
        Activity activity1 = new Activity(1, "Development");
        Activity activity2 = new Activity(2, "Testing");
        when(activityRepository.findAll()).thenReturn(Arrays.asList(activity1, activity2));

        // Act
        List<Activity> result = activityService.getAllActivities();

        // Assert
        assertEquals(2, result.size(), "Should return 2 activities");
        verify(activityRepository, times(1)).findAll();
    }
}
