package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
public class FeedServingSize {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Setter
    private String name;

    @OneToMany(mappedBy = "feedServingSize", fetch = FetchType.EAGER)
    private Set<FeedTime> feedTimes = new HashSet<>();


}
