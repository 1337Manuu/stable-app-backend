package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "stall_statuses")
public class StallStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "stall_status_id")
    private Integer stallStatusId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stall_id")
    private Stall stall;

    @Column(name = "is_occupied")
    private boolean isOccupied;

    // CONSTRUCTOR
    public StallStatus() {}

    // GETTER
    public Integer getStallStatusId() {
        return stallStatusId;
    }

    public Stall getStall() {
        return stall;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    // SETTER
    public void setStallStatusId(Integer stallStatusId) {
        this.stallStatusId = stallStatusId;
    }

    public void setStall(Stall stall) {
        this.stall = stall;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public String toString() {
        return "StallStatus{" +
                "stall=" + stall +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
