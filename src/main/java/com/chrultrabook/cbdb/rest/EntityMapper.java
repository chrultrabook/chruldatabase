package com.chrultrabook.cbdb.rest;

import com.chrultrabook.cbdb.entity.DeviceEntity;
import com.chrultrabook.cbdb.entity.DeviceNoteEntity;
import com.chrultrabook.cbdb.entity.GenerationEntity;
import com.chrultrabook.cbdb.entity.GenerationNoteEntity;
import com.chrultrabook.cbdb.rest.bean.Device;
import com.chrultrabook.cbdb.rest.bean.DeviceNote;
import com.chrultrabook.cbdb.rest.bean.Generation;
import com.chrultrabook.cbdb.rest.bean.GenerationNote;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntityMapper {

    public Generation getAndMapGenerationWithDevices(String shortName) {
        Optional<GenerationEntity> genEntityOpt = GenerationEntity.find("shortName", shortName).firstResultOptional();
        if (genEntityOpt.isEmpty()) return null;
        List<GenerationNote> notes = getNotesForGeneration(genEntityOpt.get().id);
        List<DeviceEntity> deviceEntities = DeviceEntity.list("generationId", genEntityOpt.get().id);
        List<Device> devices = deviceEntities.parallelStream().map(i -> getAndMapDevice(i.boardName)).toList();
        return genEntityOpt.get().toRecord(devices, notes);
    }

    public List<GenerationNote> getNotesForGeneration(int generationId) {
        List<GenerationNoteEntity> notes = GenerationNoteEntity.list("generationId", generationId);
        return notes.parallelStream().map(GenerationNoteEntity::toRecord).collect(Collectors.toList());
    }

    public Device getAndMapDevice(String boardName) {
        Optional<DeviceEntity> deviceEntityOpt = DeviceEntity.find("boardName", boardName).firstResultOptional();
        if (deviceEntityOpt.isEmpty()) return null;
        List<DeviceNote> notes = getNotesForDevice(deviceEntityOpt.get().id);
        return deviceEntityOpt.get().toRecord(notes);
    }

    public List<DeviceNote> getNotesForDevice(int deviceId) {
        List<DeviceNoteEntity> notes = DeviceNoteEntity.list("deviceId", deviceId);
        return notes.parallelStream().map(DeviceNoteEntity::toRecord).collect(Collectors.toList());
    }

}
