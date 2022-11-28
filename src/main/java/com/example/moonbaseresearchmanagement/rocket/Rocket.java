package com.example.moonbaseresearchmanagement.rocket;

import java.util.ArrayList;
import java.util.List;

import com.example.moonbaseresearchmanagement.transport.Transport;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "rocket")
public class Rocket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rocket_id")
    private int rocketId;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "rocket")
    private List<Transport> listTransports = new ArrayList<>();

    public Rocket() {}

    public Rocket(int rocketId, String name) {
        this.rocketId = rocketId;
        this.name = name;
    }

    public Rocket(String name, List<Transport> listTransports) {
        this.name = name;
        this.listTransports = listTransports;
    }

    public int getRocketId() {
        return rocketId;
    }

    public String getName() {
        return name;
    }

    public List<Transport> getListTransports() {
        return listTransports;
    }

    public void setRocketId(int rocketId) {
        this.rocketId = rocketId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListTransports(List<Transport> listTransports) {
        this.listTransports = listTransports;
    }

    
}
