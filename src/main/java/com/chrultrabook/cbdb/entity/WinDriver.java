package com.chrultrabook.cbdb.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "win_drivers", schema = "cbdb")
@Cacheable
public class WinDriver extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "device_id")
    public int deviceId;

    @Column(name = "generation_id")
    public int generationId;

    @Column(name = "name")
    public String name;

    @Column(name = "download_link")
    public String downloadLink;

}
