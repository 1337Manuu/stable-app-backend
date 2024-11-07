package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;

@Entity
public class Stall {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    // GETTER
    public Long getId() {
        return id;
    }

    // SETTER


    @Override
    public String toString() {
        return "Stall{" +
                "stallId=" + id +
                '}';
    }
}
