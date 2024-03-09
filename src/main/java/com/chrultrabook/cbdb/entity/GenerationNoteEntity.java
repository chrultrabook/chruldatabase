package com.chrultrabook.cbdb.entity;

import com.chrultrabook.cbdb.constants.OS;
import com.chrultrabook.cbdb.rest.bean.GenerationNote;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@EntityListeners(ReadOnlyEntity.class)
@Table(name = "generation_notes", schema = "cbdb")
@Cacheable
public class GenerationNoteEntity extends PanacheEntityBase {

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

    @Transient
    public GenerationNote toRecord() {
        return new GenerationNote(
                this.id,
                this.os,
                this.note,
                this.showIfDevNoteExists
        );
    }
}
