package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "stall_locations")
public class StallLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "stall_location_id")
    private Integer stallLocationId;

    @Column(name = "name")
    private String name;

    // CONSTRUCTORS
    public StallLocation() {}

    public StallLocation(int stallLocationId) {
        this.stallLocationId = stallLocationId;
    }

    public StallLocation(int stallLocationId, String name) {
        this.stallLocationId = stallLocationId;
        this.name = name;
    }

    // GETTER
    public Integer getStallLocationId() {
        return stallLocationId;
    }

    public String getName() {
        return name;
    }

    // SETTER

    public void setStallLocationId(Integer stallLocationId) {
        this.stallLocationId = stallLocationId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StallLocation{" +
                "stallLocationId=" + stallLocationId +
                ", name='" + name + '\'' +
                '}';
    }
}
