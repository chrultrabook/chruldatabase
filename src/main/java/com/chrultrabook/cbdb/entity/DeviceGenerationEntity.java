package com.chrultrabook.cbdb.entity;

import java.util.List;

import com.chrultrabook.cbdb.rest.bean.DeviceGeneration;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@EntityListeners(ReadOnly.class)
@Table(name = "device_generation")
@Cacheable
public class DeviceGenerationEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "short")
    public String shortName;

    @Column(name = "name")
    public String name;

    @Column(name = "baseboard")
    public String baseboard;

    @OneToMany
    public List<DeviceGenerationNoteEntity> notes;

    @OneToMany
    public List<DeviceEntity> devices;

    public DeviceGeneration toRecord() {
        return new DeviceGeneration(
                this.id,
                this.shortName,
                this.name,
                this.baseboard,
                this.notes.stream().map(DeviceGenerationNoteEntity::toRecord).toList(),
                this.devices.stream().map(DeviceEntity::toRecord).toList()
        );
    }

}
