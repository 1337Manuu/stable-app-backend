package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Entity
public class StallLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Setter
    private String name;

   @OneToMany(mappedBy = "stallLocation", fetch = FetchType.EAGER)
    private Set<Stall> stalls;
}
