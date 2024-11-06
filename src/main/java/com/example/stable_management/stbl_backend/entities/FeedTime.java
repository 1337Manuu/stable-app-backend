package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "feed_time")
public class FeedTime {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "feed_time_id")
    private Integer feedTimeId;

    @Column(name = "name")
    private String time;

    @OneToMany(mappedBy = "feedTime")
    private Set<FeedSchedule> feedSchedules = new HashSet<>();

    // CONSTRUCTORS
    public FeedTime() {}

    // GETTER
    public Set<FeedSchedule> getFeedSchedules() {
        return feedSchedules;
    }

    public Integer getFeedTimeId() {
        return feedTimeId;
    }

    public String getTime() {
        return time;
    }


    // SETTER
    public void setFeedSchedules(Set<FeedSchedule> feedSchedules) {
        this.feedSchedules = feedSchedules;
    }

    public void setFeedTimeId(Integer feedTimeId) {
        this.feedTimeId = feedTimeId;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "FeedTime{" +
                "feedTimeId=" + feedTimeId +
                ", time='" + time + '\'' +
                '}';
    }
}
