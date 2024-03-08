package com.chrultrabook.cbdb.entity.enums;

public enum OS {
    WINDOWS,
    LINUX,
    MACOS;

    public String toLowerString() {
        return super.toString().toLowerCase();
    }
}
