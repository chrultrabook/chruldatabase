package com.chrultrabook.cbdb.rest.bean;

import com.chrultrabook.cbdb.constants.OS;

public record DeviceNote (
        int id,
        OS os,
        String note
) {
}
