package com.chrultrabook.cbdb.entity;

import com.chrultrabook.cbdb.constants.OS;
import com.chrultrabook.cbdb.rest.bean.DeviceNote;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@EntityListeners(ReadOnly.class)
@Table(name = "device_note")
@Cacheable
public class DeviceNoteEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "os")
    @Enumerated(EnumType.STRING)
    public OS os;

    @Column(name = "device_id")
    public int deviceId;

    @Column(name = "note")
    public String note;

    @Transient
    public DeviceNote toRecord() {
        return new DeviceNote(
                this.id,
                this.os,
                this.note
        );
    }

}
