package com.example.stable_management.stbl_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Entity
public class StallLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Setter
    private String name;

    @Setter
    @OneToMany(mappedBy = "stallLocation", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"stallLocation"})
    private List<Stall> stalls = new ArrayList<>();

    public void addStall(Stall stall) {
        stalls.add(stall);
        stall.setStallLocation(this);
    }
}
