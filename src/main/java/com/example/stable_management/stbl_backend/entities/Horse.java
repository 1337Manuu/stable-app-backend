package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "horses")
public class Horse {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "horse_id")
    private Integer horseId;

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stall_id")
    private Stall stall;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "horse")
    private Set<FeedSchedule> feedSchedules = new HashSet<>();

    // CONSTRUCTORS
    public Horse() {}

    public Horse(String name, Stall stall, Tenant tenant) {
        this.name = name;
        this.stall = stall;
        this.tenant = tenant;
    }

    public Horse(String name, Stall stall, Tenant tenant, String note) {
        this.name = name;
        this.stall = stall;
        this.tenant = tenant;
        this.note = note;
    }

    // GETTER
    public Integer getHorseId() {
        return horseId;
    }

    public String getName() {
        return name;
    }

    public Stall getStall() {
        return stall;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public String getNote() {
        return note;
    }

    public Set<FeedSchedule> getFeedSchedules() {
        return feedSchedules;
    }

    // SETTER
    public void setHorseId(Integer horseId) {
        this.horseId = horseId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStall(Stall stall) {
        this.stall = stall;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public void setFeedSchedules(Set<FeedSchedule> feedSchedules) {
        this.feedSchedules = feedSchedules;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "horseId=" + horseId +
                ", name='" + name + '\'' +
                ", stall=" + stall +
                ", tenant=" + tenant +
                ", note='" + note + '\'' +
                '}';
    }


}
