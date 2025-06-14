package com.squadseven.timesheet.exception;


import com.squadseven.timesheet.model.BaseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.squadseven.timesheet.util.Constants.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseError> handleGenericException(Exception ex) {
        BaseError error = new BaseError(INTERNAL_SERVER_ERROR_ID,INTERNAL_SERVER_ERROR_MESSAGE);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }
    @ExceptionHandler(ActivityException.class)
    public ResponseEntity<BaseError> activityException(Exception ex) {
        BaseError error = new BaseError(ACTIVITY_ERROR_ID,ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<BaseError> illegalArgumentExceptionHandler(Exception ex) {
        BaseError error = new BaseError(ACTIVITY_ERROR_ID,ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
}
