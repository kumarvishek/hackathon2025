package com.squadseven.timesheet.service;

import com.squadseven.timesheet.model.Project;
import com.squadseven.timesheet.model.User;
import com.squadseven.timesheet.repository.ProjectRepository;
import com.squadseven.timesheet.repository.UserRepository;
import com.squadseven.timesheet.util.Constants;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;

    /**
     * Save or update a project
     */
    @Transactional
    public Project saveProject(Project project) {
        // 1. Check for duplicate by project name
        if (project.getId() == null && projectRepository.existsByName(project.getName())) {
            throw new IllegalArgumentException(Constants.DUPLICATE_PROJECT);
        }

        // 2. Validate manager
        Long managerId = project.getManager() != null ? project.getManager().getId() : null;
        if (managerId != null) {
            User manager = userRepository.findById(managerId)
                    .orElseThrow(() -> new EntityNotFoundException(Constants.MANAGER_NOT_FOUND + managerId));
            project.setManager(manager);
        } else {
            throw new IllegalArgumentException(Constants.MANAGER_ID_NOT_FOUND);
        }

        return projectRepository.save(project);
    }
}
