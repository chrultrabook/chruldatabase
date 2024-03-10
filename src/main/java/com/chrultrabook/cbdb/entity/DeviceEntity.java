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
@EntityListeners(ReadOnlyEntity.class)
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

    @Column(name = "generation_id")
    public int generationId;

    @Column(name = "brand_id")
    public int brandId;

    @Transient
    public Device toRecord(List<DeviceNote> notes) {
        Optional<BrandEntity> brand = BrandEntity.findByIdOptional(brandId);
        String brandName = "";
        if (brand.isPresent()) {
            brandName = brand.get().name;
        }
        return new Device(
                this.id,
                this.comName,
                this.boardName,
                this.eolDate,
                this.hasFullRom,
                brandName,
                notes
        );
    }

}
