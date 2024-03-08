package com.chrultrabook.cbdb.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "device", schema = "cbdb")
@Cacheable
public class Device extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "eol_date")
    public Date eolDate;

    @Column(name = "has_fullrom")
    public boolean hasFullrom;

    @Column(name = "generation_id")
    public int generationId;

    @Column(name = "brand_id")
    public int brandId;

}
