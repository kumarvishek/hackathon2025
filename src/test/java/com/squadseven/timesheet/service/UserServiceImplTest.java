package com.squadseven.timesheet.service;

import com.squadseven.timesheet.model.User;
import com.squadseven.timesheet.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {
        user1 = new User();
        user1.setId(1L);
        user1.setUsername("testuser1");
        user1.setPassword("password123"); // In a real scenario, this would be hashed

        user2 = new User();
        user2.setId(2L);
        user2.setUsername("testuser2");
        user2.setPassword("securepass");
    }

    @Test
    void getAllUsers_shouldReturnListOfUsers() {
        // Arrange
        List<User> expectedUsers = Arrays.asList(user1, user2);
        when(userRepository.findAll()).thenReturn(expectedUsers);

        // Act
        List<User> actualUsers = userService.getAllUsers();

        // Assert
        assertNotNull(actualUsers);
        assertEquals(2, actualUsers.size());
        assertEquals(expectedUsers, actualUsers);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void createUser_shouldSaveAndReturnUser() {
        // Arrange
        User newUser = new User();
        newUser.setUsername("newuser");
        newUser.setPassword("newpass");

        User savedUser = new User(); // Simulate the user after being saved (e.g., with an ID)
        savedUser.setId(3L);
        savedUser.setUsername(newUser.getUsername());
        savedUser.setPassword(newUser.getPassword());

        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        when(userRepository.save(userArgumentCaptor.capture())).thenReturn(savedUser);

        // Act
        User createdUser = userService.createUser(newUser);

        // Assert
        assertNotNull(createdUser);
        assertEquals(savedUser.getId(), createdUser.getId());
        assertEquals(newUser.getUsername(), createdUser.getUsername());

        User capturedUser = userArgumentCaptor.getValue();
        assertEquals(newUser.getUsername(), capturedUser.getUsername());
        assertEquals(newUser.getPassword(), capturedUser.getPassword());

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void getByUsernameAndPassword_whenUserExists_shouldReturnUser() {
        // Arrange
        String username = "testuser1";
        String password = "password123";
        when(userRepository.findByUsernameAndPassword(username, password)).thenReturn(Optional.of(user1));

        // Act
        Optional<User> actualUserOptional = userService.getByUsernameAndPassword(username, password);

        // Assert
        assertTrue(actualUserOptional.isPresent());
        assertEquals(user1, actualUserOptional.get());
        verify(userRepository, times(1)).findByUsernameAndPassword(username, password);
    }

}