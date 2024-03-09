package com.chrultrabook.cbdb.entity;

import com.chrultrabook.cbdb.rest.bean.Device;
import com.chrultrabook.cbdb.rest.bean.DeviceNote;
import com.chrultrabook.cbdb.rest.bean.Generation;
import com.chrultrabook.cbdb.rest.bean.GenerationNote;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

@Entity
@EntityListeners(ReadOnlyEntity.class)
@Table(name = "generation", schema = "cbdb")
@Cacheable
public class GenerationEntity extends PanacheEntityBase {

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
    public int stockKernelPartSize;

    public Generation toRecord(List<Device> devices, List<GenerationNote> notes) {
        return new Generation(
                this.id,
                this.shortName,
                this.name,
                this.baseboard,
                this.stockKernelPartSize,
                notes,
                devices
        );
    }

}
