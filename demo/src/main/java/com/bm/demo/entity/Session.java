package com.bm.demo.entity;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sid", length = 16)
    private String sid;

    @Column(name = "creator_id", length = 10)
    private String creatorId;

    @Column(name = "creator_name", length = 45)
    private String creatorName;

    @Column(name = "expiry")
    private LocalTime expiry;

    @Column(name = "uuid", length = 34)
    private String uuid;

    public Session() {}

    public Long getId() {
        return id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public LocalTime getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalTime expiry) {
        this.expiry = expiry;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
