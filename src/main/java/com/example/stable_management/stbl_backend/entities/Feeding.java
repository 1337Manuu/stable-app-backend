package com.example.stable_management.stbl_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"feed_schedule_id", "timeExpression"})})
public class Feeding {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Setter
    private String timeExpression;

    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "feed_schedule_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"note", "horse", "feedings"})
    private FeedSchedule feedSchedule;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "feed_serving_size_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"name", "feedings"})
    private FeedServingSize feedServingSize;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "feed_type_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"name", "feedings"})
    private FeedType feedType;

    public void assignFeedServingSize(FeedServingSize feedServingSize) {
        this.feedServingSize = feedServingSize;
    }

    public void assignFeedType(FeedType feedType) {
        this.feedType = feedType;
    }

    public void assignFeedSchedule(FeedSchedule feedSchedule) {
        this.feedSchedule = feedSchedule;
        feedSchedule.addFeeding(this);
    }
}
