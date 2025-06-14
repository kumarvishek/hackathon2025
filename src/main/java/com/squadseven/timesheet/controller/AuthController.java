package com.squadseven.timesheet.controller;

import com.squadseven.timesheet.model.User;
import com.squadseven.timesheet.repository.UserRepository;
import com.squadseven.timesheet.request.LoginRequest;
import com.squadseven.timesheet.response.JwtResponse;
import com.squadseven.timesheet.service.UserService;
import com.squadseven.timesheet.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        User user = userService.getByUsernameAndPassword(request.getUsername(),request.getPassword())
                                  .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtUtil.generateToken(user);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}