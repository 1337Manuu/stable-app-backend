package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;

@Entity
public class StallLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    // GETTER
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // SETTER
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StallLocation{" +
                "stallLocationId=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
