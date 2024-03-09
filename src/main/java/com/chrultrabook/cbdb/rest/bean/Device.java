package com.chrultrabook.cbdb.rest.bean;

import com.chrultrabook.cbdb.entity.BrandEntity;
import com.chrultrabook.cbdb.entity.DeviceEntity;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public record Device(
        int id,
        String comName,
        String boardName,
        Date eolDate,
        boolean hasFullRom,
        String brand,
        List<DeviceNote> notes
) {
}
