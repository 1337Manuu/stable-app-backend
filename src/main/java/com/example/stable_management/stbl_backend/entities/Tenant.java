package com.example.stable_management.stbl_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "tenant", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"tenant", "note", "stall", "feedSchedule"})
    private Set<Horse> horses = new HashSet<>();

    @OneToMany(mappedBy = "tenant", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"tenant"})
    private Set<HallBooking> hallBookings = new HashSet<>();

    @Setter
    private String name;

    @Setter
    private String phone = "N.A.";
}
