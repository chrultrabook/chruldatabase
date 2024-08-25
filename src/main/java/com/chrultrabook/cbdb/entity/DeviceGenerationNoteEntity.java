package com.chrultrabook.cbdb.entity;

import com.chrultrabook.cbdb.constants.OS;
import com.chrultrabook.cbdb.rest.bean.DeviceGenerationNote;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@EntityListeners(ReadOnly.class)
@Table(name = "device_generation_note")
@Cacheable
public class DeviceGenerationNoteEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "os")
    @Enumerated(EnumType.STRING)
    public OS os;

    @Column(name = "note")
    public String note;

    @Column(name = "show_on_device_note", columnDefinition = "BOOL")
    public boolean showIfDeviceNoteExists;

    @Transient
    public DeviceGenerationNote toRecord() {
        return new DeviceGenerationNote(
                this.id,
                this.os,
                this.note,
                this.showIfDeviceNoteExists
        );
    }
}
