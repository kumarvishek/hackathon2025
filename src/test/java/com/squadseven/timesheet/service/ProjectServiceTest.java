package com.squadseven.timesheet.service;

import com.squadseven.timesheet.model.Project;
import com.squadseven.timesheet.model.User;
import com.squadseven.timesheet.repository.ProjectRepository;
import com.squadseven.timesheet.repository.UserRepository;
import com.squadseven.timesheet.util.Constants;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ProjectService projectService;

    private Project projectToSave;
    private User manager;
    private final Long MANAGER_ID = 1L;
    private final String PROJECT_NAME = "Test Project Alpha";

    @BeforeEach
    void setUp() {
        manager = new User();
        manager.setId(MANAGER_ID);
        manager.setUsername("testManager");
        // Set other necessary fields for User if your logic depends on them

        projectToSave = new Project();
        projectToSave.setName(PROJECT_NAME);
        projectToSave.setManager(manager); // Initially set the manager object
    }

    @Test
    void saveProject_createNewProject_success() {
        // Arrange
        projectToSave.setId(null); // Explicitly for creation

        Project savedProject = new Project();
        savedProject.setId(100L);
        savedProject.setName(PROJECT_NAME);
        savedProject.setManager(manager);

        when(projectRepository.existsByName(PROJECT_NAME)).thenReturn(false);
        when(userRepository.findById(MANAGER_ID)).thenReturn(Optional.of(manager));
        when(projectRepository.save(any(Project.class))).thenReturn(savedProject);

        // Act
        Project result = projectService.saveProject(projectToSave);

        // Assert
        assertNotNull(result);
        assertEquals(savedProject.getId(), result.getId());
        assertEquals(PROJECT_NAME, result.getName());
        assertEquals(manager, result.getManager());

        verify(projectRepository).existsByName(PROJECT_NAME);
        verify(userRepository).findById(MANAGER_ID);
        verify(projectRepository).save(projectToSave); // or use ArgumentCaptor for more detailed checks
    }

    @Test
    void saveProject_createNewProject_duplicateName_throwsIllegalArgumentException() {
        // Arrange
        projectToSave.setId(null); // Creation
        when(projectRepository.existsByName(PROJECT_NAME)).thenReturn(true);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            projectService.saveProject(projectToSave);
        });

        assertEquals(Constants.DUPLICATE_PROJECT, exception.getMessage());
        verify(projectRepository).existsByName(PROJECT_NAME);
        verify(userRepository, never()).findById(anyLong());
        verify(projectRepository, never()).save(any(Project.class));
    }

    @Test
    void saveProject_managerNotFound_throwsEntityNotFoundException() {
        // Arrange
        Long nonExistentManagerId = 99L;
        User managerWithNonExistentId = new User();
        managerWithNonExistentId.setId(nonExistentManagerId);
        projectToSave.setManager(managerWithNonExistentId); // Set manager with the non-existent ID

        if (projectToSave.getId() == null) { // If it's a create scenario
            when(projectRepository.existsByName(PROJECT_NAME)).thenReturn(false);
        }
        when(userRepository.findById(nonExistentManagerId)).thenReturn(Optional.empty());

        // Act & Assert
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            projectService.saveProject(projectToSave);
        });

        assertEquals(Constants.MANAGER_NOT_FOUND + nonExistentManagerId, exception.getMessage());
        if (projectToSave.getId() == null) {
            verify(projectRepository).existsByName(PROJECT_NAME);
        }
        verify(userRepository).findById(nonExistentManagerId);
        verify(projectRepository, never()).save(any(Project.class));
    }

    @Test
    void saveProject_managerIdNotProvided_throwsIllegalArgumentException() {
        // Arrange
        projectToSave.setManager(null); // Manager object is null

        if (projectToSave.getId() == null) { // If it's a create scenario
            when(projectRepository.existsByName(PROJECT_NAME)).thenReturn(false);
        }

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            projectService.saveProject(projectToSave);
        });

        assertEquals(Constants.MANAGER_ID_NOT_FOUND, exception.getMessage());
        if (projectToSave.getId() == null) {
            verify(projectRepository).existsByName(PROJECT_NAME);
        }
        verify(userRepository, never()).findById(anyLong());
        verify(projectRepository, never()).save(any(Project.class));
    }

    @Test
    void saveProject_managerObjectExistsButIdIsNull_throwsIllegalArgumentException() {
        // Arrange
        User managerWithNullId = new User(); // Manager object exists
        managerWithNullId.setId(null);       // But its ID is null
        projectToSave.setManager(managerWithNullId);

        if (projectToSave.getId() == null) { // If it's a create scenario
            when(projectRepository.existsByName(PROJECT_NAME)).thenReturn(false);
        }

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            projectService.saveProject(projectToSave);
        });

        assertEquals(Constants.MANAGER_ID_NOT_FOUND, exception.getMessage());
        if (projectToSave.getId() == null) {
            verify(projectRepository).existsByName(PROJECT_NAME);
        }
        verify(userRepository, never()).findById(anyLong());
        verify(projectRepository, never()).save(any(Project.class));
    }
}