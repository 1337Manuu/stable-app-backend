package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Stall {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Setter
    private Boolean isOccupied;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "horse_id", referencedColumnName = "id")
    private Horse horse;

    @ManyToOne
    @JoinColumn(name = "stall_location_id", referencedColumnName = "id")
    private StallLocation stallLocation;

    @PrePersist
    @PreUpdate
    public void setOccupancyStatus() {
        isOccupied = horse != null;
    }

    public void assignHorse(Horse horse) {
        this.horse = horse;
    }

    public void assignStallLocation(StallLocation stallLocation) {
        this.stallLocation = stallLocation;
    }
}
