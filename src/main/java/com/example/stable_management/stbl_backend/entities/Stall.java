package com.example.stable_management.stbl_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private Integer stallNumber;

    @Setter
    private Boolean isOccupied;

    @OneToOne(mappedBy = "stall", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"stall", "tenant"})
    @Setter
    private Horse horse;

    @ManyToOne
    @JoinColumn(name = "stall_location_id", referencedColumnName = "id")
    @JsonIgnoreProperties("stalls")
    @Setter
    private StallLocation stallLocation;

    @PrePersist
    @PreUpdate
    public void setOccupancyStatus() {
        isOccupied = horse != null;
    }

    public void assignHorse(Horse horse) {
        this.horse = horse;
        if (horse.getStall() != this) {
            horse.setStall(this);
        }
    }

    public void assignStallLocation(StallLocation stallLocation) {
        this.stallLocation = stallLocation;
        stallLocation.addStall(this);
    }

}
