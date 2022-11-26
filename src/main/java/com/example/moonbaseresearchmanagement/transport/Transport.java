package com.example.moonbaseresearchmanagement.transport;

import java.time.LocalDateTime;
import java.util.List;

import com.example.moonbaseresearchmanagement.moonresearcher.MoonResearcher;
import com.example.moonbaseresearchmanagement.rocket.Rocket;

import jakarta.persistence.*;

@Entity
@Table(name = "transport")
public class Transport {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transport_id")
    private int transportId;

    @ManyToOne
    @JoinColumn(name = "rocket_id")
    private Rocket rocketId;

    private String arrivalDeparture;

    private LocalDateTime time;

    private String fromTo; 
    
    @ManyToMany(mappedBy = "listTransports")
    private List<MoonResearcher> listMoonReserachers;

    public Transport(){}
    
    public Transport(int transportId, Rocket rocketId, String arrivalDeparture, LocalDateTime time, String fromTo) {
        this.transportId = transportId;
        this.rocketId = rocketId;
        this.arrivalDeparture = arrivalDeparture;
        this.time = time;
        this.fromTo = fromTo;
    }

    public int getTransportId() {
        return transportId;
    }

    public Rocket getRocketId() {
        return rocketId;
    }

    public String getArrivalDeparture() {
        return arrivalDeparture;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getFromTo() {
        return fromTo;
    }

    public List<MoonResearcher> getListMoonReserachers() {
        return listMoonReserachers;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }

    public void setRocketId(Rocket rocketId) {
        this.rocketId = rocketId;
    }

    public void setArrivalDeparture(String arrivalDeparture) {
        this.arrivalDeparture = arrivalDeparture;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }

    public void setListMoonReserachers(List<MoonResearcher> listMoonReserachers) {
        this.listMoonReserachers = listMoonReserachers;
    }

    

}