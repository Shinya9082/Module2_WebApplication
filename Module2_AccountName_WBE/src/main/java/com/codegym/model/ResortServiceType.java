package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service_type")
public class ResortServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private long id;
    @Column(name = "service_type_name")
    private String name;
    @OneToMany(targetEntity = ResortService.class)
    private List<ResortService> resortServices;

    public ResortServiceType() {
    }

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

    public List<ResortService> getResortServices() {
        return resortServices;
    }

    public void setResortServices(List<ResortService> resortServices) {
        this.resortServices = resortServices;
    }
}
