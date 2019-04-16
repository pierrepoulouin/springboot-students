package fr.formation.students.controllers;

public class ValidationError {

    private String atributeName;
    private String errorCode;

    public ValidationError() {
    }

    public ValidationError(String atributeName, String errorCode) {
        this.atributeName = atributeName;
        this.errorCode = errorCode;
    }

    public String getAtributeName() {
        return atributeName;
    }

    public void setAtributeName(String atributeName) {
        this.atributeName = atributeName;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


}
