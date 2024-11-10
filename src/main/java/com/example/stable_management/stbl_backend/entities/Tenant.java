package com.example.stable_management.stbl_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "tenant", fetch = FetchType.EAGER)
    private Set<Horse> horses = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "tenant", fetch = FetchType.EAGER)
    private Set<HallBooking> hallBookings = new HashSet<>();

    @Setter
    private String name;

    @Setter
    private String phone = "N.A.";
}
