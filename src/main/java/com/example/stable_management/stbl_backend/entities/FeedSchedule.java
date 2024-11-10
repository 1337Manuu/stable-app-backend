package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    // MANY FeedSchedules can have MANY FeedTimes, but each FeedTime must be UNIQUE
    // ONE FeedSchedule can have ONE FeedServingSize and ONE FeedServingSize can have MANY FeedSchedules
    // ONE FeedSchedule can have ONE FeedType and ONE FeedType can have MANY FeedSchedules
    public void setHorse(Horse horse) {
        this.horse = horse;

        // Set the other side of the relationship.
        if (horse.getFeedSchedule() != this) {
            horse.assignFeedSchedule(this);
        }
    }
}
