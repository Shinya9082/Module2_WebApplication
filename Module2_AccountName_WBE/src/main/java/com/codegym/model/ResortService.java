package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class ResortService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private long id;
    @Column(name = "service_name")
    private String name;
    @Column(name = "service_area")
    private int area;
    @Column(name = "service_floor")
    private int floor;
    @Column(name = "service_max_people")
    private int maxPeople;
    @Column(name = "service_rent_price")
    private int rentPrice;
    @Column(name = "service_status")
    private String status;
    @Column(name = "service_rent_type_Id")
    private String rentTypeId;

    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ResortServiceType resortServiceType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(String rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public ResortServiceType getResortServiceType() {
        return resortServiceType;
    }

    public void setResortServiceType(ResortServiceType resortServiceType) {
        this.resortServiceType = resortServiceType;
    }
}
