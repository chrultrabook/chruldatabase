package com.chrultrabook.cbdb.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

@RegisterForReflection
public class ReadOnly {

    @PrePersist
    void onPrePersist(Object o) {
        throw new IllegalStateException("JPA is trying to persist an entity of type " + (o == null ? "null" : o.getClass()));
    }

    @PreUpdate
    void onPreUpdate(Object o) {
        throw new IllegalStateException("JPA is trying to update an entity of type " + (o == null ? "null" : o.getClass()));
    }

    @PreRemove
    void onPreRemove(Object o) {
        throw new IllegalStateException("JPA is trying to remove an entity of type " + (o == null ? "null" : o.getClass()));
    }

}
