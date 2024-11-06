package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "feed_type")
public class FeedType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "feed_type_id")
    private Integer feedTypeId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "feedType")
    private Set<FeedSchedule> feedSchedules = new HashSet<>();

    // CONSTRUCTORS
    public  FeedType() {}


    // GETTER
    public Set<FeedSchedule> getFeedSchedules() {
        return feedSchedules;
    }

    public Integer getFeedTypeId() {
        return feedTypeId;
    }

    public String getName() {
        return name;
    }

    // SETTER
    public void setFeedSchedules(Set<FeedSchedule> feedSchedules) {
        this.feedSchedules = feedSchedules;
    }

    public void setFeedTypeId(Integer feedTypeId) {
        this.feedTypeId = feedTypeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FeedType{" +
                "feedTypeId=" + feedTypeId +
                ", type='" + name + '\'' +
                '}';
    }
}
