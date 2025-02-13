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
public class FeedServingSize {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Setter
    private String name;

    @OneToMany(mappedBy = "feedServingSize", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"timeExpression", "feedSchedule", "feedServingSize", "feedType"})
    private List<Feeding> feedings = new ArrayList<>();

}