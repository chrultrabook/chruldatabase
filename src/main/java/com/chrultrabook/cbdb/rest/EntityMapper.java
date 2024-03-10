package com.chrultrabook.cbdb.rest;

import com.chrultrabook.cbdb.entity.DeviceEntity;
import com.chrultrabook.cbdb.entity.DeviceNoteEntity;
import com.chrultrabook.cbdb.entity.GenerationEntity;
import com.chrultrabook.cbdb.entity.GenerationNoteEntity;
import com.chrultrabook.cbdb.rest.bean.Device;
import com.chrultrabook.cbdb.rest.bean.DeviceNote;
import com.chrultrabook.cbdb.rest.bean.Generation;
import com.chrultrabook.cbdb.rest.bean.GenerationNote;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class EntityMapper {

    public List<Generation> getEverything() {
        List<GenerationEntity> generationEntityList = GenerationEntity.listAll();
        return generationEntityList.parallelStream().map(this::getAndMapGenerationWithDevices).toList();
    }

    public Generation getAndMapGenerationWithDevices(GenerationEntity gen) {
        List<GenerationNote> notes = getNotesForGeneration(gen.id);
        List<DeviceEntity> deviceEntities = DeviceEntity.list("generationId", gen.id);
        List<Device> devices = deviceEntities.parallelStream().map(this::getAndMapDevice).toList();
        return gen.toRecord(devices, notes);
    }

    private List<GenerationNote> getNotesForGeneration(int generationId) {
        List<GenerationNoteEntity> notes = GenerationNoteEntity.list("generationId", generationId);
        return notes.parallelStream().map(GenerationNoteEntity::toRecord).collect(Collectors.toList());
    }

    public Device getAndMapDevice(DeviceEntity device) {
        List<DeviceNote> notes = getNotesForDevice(device.id);
        return device.toRecord(notes);
    }

    private List<DeviceNote> getNotesForDevice(int deviceId) {
        List<DeviceNoteEntity> notes = DeviceNoteEntity.list("deviceId", deviceId);
        return notes.parallelStream().map(DeviceNoteEntity::toRecord).collect(Collectors.toList());
    }

}
