package fr.formation.students.controllers;


import java.time.LocalDateTime;
import java.util.List;

public class ApiError {

  private LocalDateTime timestamp;
  private int httpCode;
  private String httpMessage;
  private int countErrors;

  private List<ValidationError> errors;

    public ApiError() {
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getHttpMessage() {
        return httpMessage;
    }

    public void setHttpMessage(String httpMessage) {
        this.httpMessage = httpMessage;
    }

    public int getCountErrors() {
        return countErrors;
    }

    public void setCountErrors(int totalErrors) {
        this.countErrors = totalErrors;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    public void setErrors(List<ValidationError> errors) {
        this.errors = errors;
    }
}
