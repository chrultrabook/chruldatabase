package com.chrultrabook.cbdb.entity;

import com.chrultrabook.cbdb.entity.enums.OS;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "device_notes", schema = "cbdb")
@Cacheable
public class DeviceNote extends PanacheEntityBase {

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

}
