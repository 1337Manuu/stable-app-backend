package com.example.stable_management.stbl_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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


    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "id")
    @Setter
    @JsonIgnoreProperties({"horses", "phone", "hallBookings"})
    private Tenant tenant;

    @OneToOne
    @JoinColumn(name = "stall_id", referencedColumnName = "id")
    @Setter
    @JsonIgnoreProperties({"isOccupied", "name", "horse"})
    private Stall stall;

    @JsonIgnoreProperties({"note", "horse"})
    @OneToOne(mappedBy = "horse", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FeedSchedule feedSchedule;

    public void assignTenant(Tenant tenant) {
        this.tenant = tenant;
        tenant.addHorse(this);
    }

    public void assignStall(Stall stall) {
        this.stall = stall;
        if (stall.getHorse() != this) {
            stall.setHorse(this);
        }
    }

    public void assignFeedSchedule(FeedSchedule feedSchedule) {
        this.feedSchedule = feedSchedule;

        if (feedSchedule.getHorse() != this) {
            feedSchedule.assignHorse(this);
        }
    }
}
