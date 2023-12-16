package com.example.cm2115.model;

public enum CustomerType {
    FIRST_STRING("Individual"),
    SECOND_STRING("Business"),
    THIRD_STRING("Charity");

    private final String value;

    CustomerType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
