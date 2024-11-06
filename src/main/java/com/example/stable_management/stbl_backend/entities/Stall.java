package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "stalls")
public class Stall {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "stall_id")
    private Integer stallId;

    @ManyToOne
    @JoinColumn(name = "stall_location_id")
    private StallLocation stallLocation;

    @OneToOne(mappedBy = "stall", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Horse horse;

    @OneToOne(mappedBy = "stall", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private StallStatus stallStatus;

    // CONSTRUCTORS
    public Stall() {}

    public Stall(int stallId) {
        this.stallId = stallId;
    }

    public Stall(int stallId, StallLocation stallLocation) {
        this.stallId = stallId;
        this.stallLocation = stallLocation;
    }

    // GETTER
    public Horse getHorse() {
        return horse;
    }

    public Integer getStallId() {
        return stallId;
    }

    public StallLocation getStallLocation() {
        return stallLocation;
    }

    // SETTER
    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public void setStallId(Integer stallId) {
        this.stallId = stallId;
    }

    public void setStallLocation(StallLocation stallLocation) {
        this.stallLocation = stallLocation;
    }

    @Override
    public String toString() {
        return "Stall{" +
                "stallId=" + stallId +
                ", stallLocation=" + stallLocation +
                '}';
    }
}
