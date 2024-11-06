package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "hall_booking")
public class HallBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "hall_booking_id")
    private Integer hallBookingId;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // CONSTRUCTORS

    // GETTER
    public int getHallBookingId() {
        return hallBookingId;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // SETTER
    public void setHallBookingId(Integer hallBookingId) {
        this.hallBookingId = hallBookingId;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "\nHallBooking{\n" +
                "ridingHallBookingId=" + hallBookingId +
                ",\n horse=" + tenant +
                ",\n startTime=" + startTime +
                ",\n endTime=" + endTime +
                ",\n createdAt=" + createdAt +
                '}';
    }
}
