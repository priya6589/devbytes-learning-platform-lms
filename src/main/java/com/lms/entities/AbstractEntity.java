package com.lms.entities;

import java.io.Serializable;
import java.sql.Timestamp;

public abstract class AbstractEntity  implements Serializable {

    protected int id;
    protected String uuid;
    protected int version;
    protected Timestamp createdAt;
    protected Timestamp updatedAt;
    protected Timestamp deletedAt;

    public AbstractEntity() {
    }

    public AbstractEntity(int id, String uuid, int version, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
        this.id = id;
        this.uuid = uuid;
        this.version = version;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public AbstractEntity(int id, String uuid, int version, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.version = version;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }
}
