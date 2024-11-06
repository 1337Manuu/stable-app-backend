package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "feed_schedule")
public class FeedSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "feed_schedule_id")
    private Integer feedScheduleId;

    @ManyToOne
    @JoinColumn(name = "horse_id")
    private Horse horse;

    @ManyToOne
    @JoinColumn(name = "feed_type_id")
    private FeedType feedType;

    @ManyToOne
    @JoinColumn(name = "feed_serving_size_id")
    private FeedServingSize feedServingSize;

    @ManyToOne
    @JoinColumn(name = "feed_time_id")
    private FeedTime feedTime;

    @Column(name = "note")
    private String note;

    // CONSTRUCTORS
    public FeedSchedule() {}


    // GETTER
    public Integer getFeedScheduleId() {
        return feedScheduleId;
    }

    public Horse getHorse() {
        return horse;
    }

    public FeedType getFeedType() {
        return feedType;
    }

    public FeedServingSize getFeedServingSize() {
        return feedServingSize;
    }

    public FeedTime getFeedTime() {
        return feedTime;
    }

    public String getNote() {
        return note;
    }

    // SETTER
    public void setFeedScheduleId(Integer feedScheduleId) {
        this.feedScheduleId = feedScheduleId;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public void setFeedType(FeedType feedType) {
        this.feedType = feedType;
    }

    public void setFeedServingSize(FeedServingSize feedServingSize) {
        this.feedServingSize = feedServingSize;
    }

    public void setFeedTime(FeedTime feedTime) {
        this.feedTime = feedTime;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "FeedSchedule{" +
                "feedScheduleId=" + feedScheduleId +
                ", horse=" + horse +
                ", feedType=" + feedType +
                ", feedServingSize=" + feedServingSize +
                ", feedTime=" + feedTime +
                ", note='" + note + '\'' +
                '}';
    }
}
