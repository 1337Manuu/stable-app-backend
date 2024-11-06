package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "feed_serving_size")
public class FeedServingSize {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "feed_serving_size_id")
    Integer feedServingSizeId;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "feedServingSize")
    private Set<FeedSchedule> feedSchedules = new HashSet<>();

    // CONSTRUCTORS
    public FeedServingSize() {}

    // GETTER
    public Set<FeedSchedule> getFeedSchedules() {
        return feedSchedules;
    }

    public Integer getFeedServingSizeId() {
        return feedServingSizeId;
    }

    public String getName() {
        return name;
    }

    // SETTER
    public void setFeedSchedules(Set<FeedSchedule> feedSchedules) {
        this.feedSchedules = feedSchedules;
    }

    public void setFeedServingSizeId(Integer feedServingSizeId) {
        this.feedServingSizeId = feedServingSizeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FeedServingSize{" +
                "feedServingSizeId=" + feedServingSizeId +
                ", servingSize='" + name + '\'' +
                '}';
    }
}
