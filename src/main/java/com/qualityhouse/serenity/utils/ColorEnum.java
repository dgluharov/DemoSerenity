package com.qualityhouse.serenity.utils;

public enum ColorEnum {
    BLUE("blue"),
    ORANGE("orange");

    private String value;

    ColorEnum(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
