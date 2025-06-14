package com.squadseven.timesheet.model;

import lombok.Data;

import java.util.Date;

@Data
public class BaseError {
    private int errorId;
    private String errorMessage;
    private Date time;

    public BaseError(int errorId, String errorMessage) {
        this.errorId = errorId;
        this.errorMessage = errorMessage;
        this.time = new Date();
    }

}
