package com.chrultrabook.cbdb.rest.bean;

import java.util.List;

public record Generation(
        int id,
        String shortName,
        String name,
        String baseboard,
        int stockKernelPartSize,
        List<GenerationNote> notes,
        List<Device> devices
) {
}
