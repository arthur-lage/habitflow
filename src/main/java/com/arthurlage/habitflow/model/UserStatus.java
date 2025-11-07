package com.arthurlage.habitflow.model;

import lombok.Getter;

@Getter
public enum UserStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive");

    private final String label;

    UserStatus(String label) {
        this.label = label;
    }
}
