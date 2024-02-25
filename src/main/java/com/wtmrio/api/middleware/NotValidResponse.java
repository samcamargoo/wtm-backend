package com.wtmrio.api.middleware;

import java.util.ArrayList;
import java.util.List;

public class NotValidResponse {

    private List<String> globalErrors = new ArrayList<>();
    private List<FieldErrorOutput> fieldErrors = new ArrayList<>();

    public List<String> getGlobalErrors() {
        return globalErrors;
    }

    public List<FieldErrorOutput> getFieldErrors() {
        return fieldErrors;
    }

    public void addGlobalError(String message) {
        globalErrors.add(message);
    }

    public void addFieldError(String field, String message) {
        fieldErrors.add(new FieldErrorOutput(field, message));
    }
}
