package com.labanovich.model.entities;

public enum Status {
    EXECUTED(true),
    NOT_EXECUTED(false);

    private boolean isExecute;

    Status(boolean isExecute) {
        this.isExecute = isExecute;
    }

    public boolean isExecute() {
        return isExecute;
    }
}
