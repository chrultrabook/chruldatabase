package com.chrultrabook.cbdb.entity;

import com.chrultrabook.cbdb.rest.bean.Device;
import com.chrultrabook.cbdb.rest.bean.DeviceNote;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Entity
@EntityListeners(ReadOnly.class)
@Table(name = "device")
@Cacheable
public class DeviceEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "com_name")
    @Nullable
    public String comName;

    @Column(name = "board_name")
    public String boardName;

    @Column(name = "eol_date")
    public Date eolDate;

    @Column(name = "has_full_rom", columnDefinition = "BOOL")
    public boolean hasFullRom;

    @Column(name = "wp_method")
    public String wpMethod;

    @Column(name = "wp_method_type")
    public String wpMethodType;

    @Column(name = "stock_kernel_part_size")
    public int stockKernelPartSize;

    @ManyToOne
    public BrandEntity brand;

    @OneToMany
    public List<DeviceNoteEntity> notes;

    @Transient
    public Device toRecord() {
        return new Device(
                this.id,
                this.comName,
                this.boardName,
                this.eolDate,
                this.hasFullRom,
                this.wpMethod,
                this.stockKernelPartSize,
                this.brand.name,
                this.notes.stream().map(DeviceNoteEntity::toRecord).toList()
        );
    }

}
