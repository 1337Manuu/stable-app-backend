package com.example.stable_management.stbl_backend.entities;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tenants")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "tenant_id")
    private Integer tenantId;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone = "N.A.";

    @OneToMany(mappedBy = "tenant")
    private Set<Horse> horses = new HashSet<>();

    @OneToMany(mappedBy = "tenant")
    private Set<HallBooking> hallBookings = new HashSet<>();

    // CONSTRUCTOR
    public Tenant() {}

    // GETTER
    public Set<Horse> getHorses() {
        return horses;
    }

    public Set<HallBooking> getHallBookings() {
        return hallBookings;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    // SETTER
    public void setHorses(Set<Horse> horses) {
        this.horses = horses;
    }

    public void setHallBookings(Set<HallBooking> hallBookings) {
        this.hallBookings = hallBookings;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "tenantId=" + tenantId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
