package com.example.stable_management.stbl_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Horse {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Setter
    private String name;

    @Setter
    private String note;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tenant_id", referencedColumnName = "id")
    @Setter
    private Tenant tenant;

    @JsonIgnore
    @OneToOne(mappedBy = "horse", fetch = FetchType.EAGER)
    private Stall stall;

    @JsonIgnore
    @OneToOne(mappedBy = "horse", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FeedSchedule feedSchedule;

    public void assignTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public void assignFeedSchedule(FeedSchedule feedSchedule) {
        this.feedSchedule = feedSchedule;

        if (feedSchedule.getHorse() != this) {
            feedSchedule.setHorse(this);
        }
    }
}
