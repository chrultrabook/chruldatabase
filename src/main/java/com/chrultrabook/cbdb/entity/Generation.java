package com.chrultrabook.cbdb.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "generation", schema = "cbdb")
@Cacheable
public class Generation extends PanacheEntityBase {

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

    @Column(name = "stock_kernel_partsize")
    public int stockKernelPartsize;

}
