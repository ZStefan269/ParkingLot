package com.parking.parkinglot.entities;

import jakarta.persistence.*;

@Entity
public class Car {
    private Long id;
    private String LICENSEPLATE;
    private String PARKINGSPOT;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
    private User owner;

    @Basic
    public String getLICENSEPLATE() {
        return LICENSEPLATE;
    }

    public void setLICENSEPLATE(String LICENSEPLATE) {
        this.LICENSEPLATE = LICENSEPLATE;
    }
    @Basic
    public String getPARKINGSPOT() {
        return PARKINGSPOT;
    }

    public void setPARKINGSPOT(String PARKINGSPOT) {
        this.PARKINGSPOT = PARKINGSPOT;
    }

    @ManyToOne
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
}

