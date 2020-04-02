package com.qualityhouse.serenity.utils;

public enum ColorEnum {

    ORANGE("Orange"),
    BLUE("Blue");

    private String value;

    ColorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
