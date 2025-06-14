package com.squadseven.timesheet.model;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String username;
    private String password;
    private int roleId;
}
