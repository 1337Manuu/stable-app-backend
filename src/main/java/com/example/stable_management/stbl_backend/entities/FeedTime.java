package com.example.stable_management.stbl_backend.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class FeedTime {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String timeExpression;

    // GETTER
    public Long getId() {
        return id;
    }

    public String getTimeExpression() {
        return timeExpression;
    }


    // SETTER
    public void setTimeExpression(String timeExpression) {
        this.timeExpression = timeExpression;
    }

    @Override
    public String toString() {
        return "FeedTime{" +
                "feedTimeId=" + id +
                ", time='" + timeExpression + '\'' +
                '}';
    }
}
