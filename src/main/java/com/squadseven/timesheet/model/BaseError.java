package com.squadseven.timesheet.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class BaseError {
    private int errorId;
    private String errorMessage;
    private Date time;

    public BaseError() {
    }

    public BaseError(int errorId, String errorMessage) {
        this.errorId = errorId;
        this.errorMessage = errorMessage;
        this.time = new Date();
    }
    public int getErrorId() {
        return errorId;
    }

    public void setErrorId(int errorId) {
        this.errorId = errorId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
