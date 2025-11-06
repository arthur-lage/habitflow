package com.arthurlage.habitflow.model;

public enum HabitStatus {
    ACTIVE("Active"),
    PAUSED("Paused"),
    COMPLETED("Completed"),
    INACTIVE("Inactive");

    private final String label;

    HabitStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
