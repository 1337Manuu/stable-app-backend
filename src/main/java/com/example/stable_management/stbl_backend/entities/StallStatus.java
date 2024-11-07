package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;

@Entity
public class StallStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private boolean isOccupied;

    // GETTER
    public Integer getId() {
        return id;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    // SETTER
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public String toString() {
        return "StallStatus{" +
                "id=" + id +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
