package com.chrultrabook.cbdb.constants;

public enum OS {
    WINDOWS,
    LINUX,
    MACOS;

    public String toLowerString() {
        return super.toString().toLowerCase();
    }
}
