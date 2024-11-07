package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class FeedType {

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
        return "FeedType{" +
                "feedTypeId=" + id +
                ", type='" + name + '\'' +
                '}';
    }
}
