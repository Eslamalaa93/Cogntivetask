package com.cognitev.application.cognitevtask.validation;

/**
 * Created by Eslam
 *
 * Usage : Set some of Constrains for Validation
 */
public enum ValidatorConstants {
    EMAIL("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$"),
    PHONENUMBER("^\\+?[1-9]\\d{1,14}$"),
    DATE("^\\d{4}-\\d{2}-\\d{2}$"),
    ISNUMBER("[0-9]");

    private String value;

    ValidatorConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
