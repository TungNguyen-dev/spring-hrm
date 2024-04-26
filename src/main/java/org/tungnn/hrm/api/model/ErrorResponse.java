package org.tungnn.hrm.api.model;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {
    private String message = "Internal Server Error";

    private List<Error> errors = new ArrayList<>();

    public ErrorResponse() {};

    public ErrorResponse(String message) {
        this.message = message;
    };

    public ErrorResponse(String message, List<Error> errors) {
        this.message = message;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
