package com.chrultrabook.cbdb.rest.bean;

import java.util.List;

public record DeviceGeneration(
        int id,
        String shortName,
        String name,
        String baseboard,
        List<DeviceGenerationNote> notes,
        List<Device> devices
) {
}
