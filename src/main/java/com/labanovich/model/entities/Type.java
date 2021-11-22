package com.labanovich.model.entities;

public enum Type {
    CONFERENCE("Conference"),
    LECTURE("Lecture"),
    TRAINING("Training");

    private String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
