package com.squadseven.timesheet.repository;

import com.squadseven.timesheet.model.Project;
import com.squadseven.timesheet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    // Find all active projects
    List<Project> findByIsActiveTrue();

    // Find all projects by manager
    List<Project> findByManager(User manager);

    // Find all active projects by manager
    List<Project> findByManagerAndIsActiveTrue(User manager);

    boolean existsByName(String name);
}
