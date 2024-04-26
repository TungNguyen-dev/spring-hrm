package org.tungnn.hrm.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.tungnn.hrm.api.model.Error;
import org.tungnn.hrm.api.model.ErrorResponse;
import org.tungnn.hrm.domain.exception.EntityNotFoundException;

import java.util.Collections;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(Exception ex, WebRequest request) {
        Error error = new Error("HRM-000", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Not Found", Collections.singletonList(error));

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex, WebRequest request) {
        Error error = new Error("HRM-000", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Internal Server Error", Collections.singletonList(error));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
