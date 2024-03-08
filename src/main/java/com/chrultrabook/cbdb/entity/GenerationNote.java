package com.chrultrabook.cbdb.entity;

import com.chrultrabook.cbdb.entity.enums.OS;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "generation_notes", schema = "cbdb")
@Cacheable
public class GenerationNote extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "os")
    @Enumerated(EnumType.STRING)
    public OS os;

    @Column(name = "generation_id")
    public int generationId;

    @Column(name = "note")
    public String note;

    @Column(name = "show_on_dev_note")
    public boolean showIfDevNoteExists;

}
