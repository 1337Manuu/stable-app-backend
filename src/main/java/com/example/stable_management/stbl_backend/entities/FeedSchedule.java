package com.example.stable_management.stbl_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class FeedSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Setter
    private String note = "Keine Notiz hinterlegt.";

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "horse_id", referencedColumnName = "id")
    @Setter
    private Horse horse;

    @Setter
    @JsonIgnore
    @OneToMany(mappedBy = "feedSchedule", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"timeExpression", "feedSchedule", "feedServingSize", "feedType"})
    private List<Feeding> feedings = new ArrayList<>();

    public void assignHorse(Horse horse) {
        this.horse = horse;

        if (horse.getFeedSchedule() != this) {
            horse.assignFeedSchedule(this);
        }
    }

    public void addFeeding(Feeding feeding) {
        feedings.add(feeding);

        if (feeding.getFeedSchedule() != this) {
            feeding.assignFeedSchedule(this);
        }
    }
}
