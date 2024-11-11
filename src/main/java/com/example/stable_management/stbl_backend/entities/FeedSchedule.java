package com.example.stable_management.stbl_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
public class FeedSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Setter
    private String note;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "horse_id", referencedColumnName = "id")
    private Horse horse;

    @JsonIgnore
    @OneToMany(mappedBy = "feedSchedule", fetch = FetchType.EAGER)
    private Set<FeedTime> feedTimes = new HashSet<>();

    public void setHorse(Horse horse) {
        this.horse = horse;

        // Set the other side of the relationship.
        if (horse.getFeedSchedule() != this) {
            horse.assignFeedSchedule(this);
        }
    }
}
