package com.springmvc.config.enums;

public enum Constants {
    ROOT_CONTEXT("Amazonly");

    private final String value;

    Constants(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
