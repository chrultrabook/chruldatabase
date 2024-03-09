package com.chrultrabook.cbdb.rest.bean;

import com.chrultrabook.cbdb.constants.OS;
import com.chrultrabook.cbdb.entity.DeviceNoteEntity;

public record DeviceNote (
        int id,
        OS os,
        String note
) {
}
