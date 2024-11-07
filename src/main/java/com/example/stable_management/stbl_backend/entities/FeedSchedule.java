package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;

@Entity
public class FeedSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String note;

    // GETTER
    public Long getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    // SETTER
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "FeedSchedule{" +
                "feedScheduleId=" + id +
                ", note='" + note + '\'' +
                '}';
    }
}
