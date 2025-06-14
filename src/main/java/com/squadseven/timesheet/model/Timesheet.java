package com.squadseven.timesheet.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String project;
    private String contractor;
    private Date week_start;
    private String status;
    private int totalHours;
    private String message;
}
