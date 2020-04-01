package com.qualityhouse.serenity.utils;

public enum SizeEnum {

    S("1"),
    M("2"),
    L("3");

    private String value;

    SizeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
