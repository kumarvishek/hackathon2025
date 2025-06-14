package com.squadseven.timesheet.service;

import com.squadseven.timesheet.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    User createUser(User user);

    Optional<User> getByUsernameAndPassword(String username, String password);
}