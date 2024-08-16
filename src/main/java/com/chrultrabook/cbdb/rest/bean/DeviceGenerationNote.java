package com.chrultrabook.cbdb.rest.bean;

import com.chrultrabook.cbdb.constants.OS;

public record DeviceGenerationNote(
        int id,
        OS os,
        String note,
        boolean showIfDeviceNotePresent
) {
}
