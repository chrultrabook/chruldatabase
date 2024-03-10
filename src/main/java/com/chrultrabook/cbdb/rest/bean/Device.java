package com.chrultrabook.cbdb.rest.bean;

import java.sql.Date;
import java.util.List;

public record Device(
        int id,
        String comName,
        String boardName,
        Date eolDate,
        boolean hasFullRom,
        String wpMethod,
        int stockKernelPartSize,
        String brand,
        List<DeviceNote> notes
) {
}
