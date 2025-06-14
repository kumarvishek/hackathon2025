package com.squadseven.timesheet.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

}
