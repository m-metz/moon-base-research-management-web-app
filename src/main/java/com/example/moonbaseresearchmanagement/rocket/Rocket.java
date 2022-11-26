package com.example.moonbaseresearchmanagement.rocket;

import java.util.List;

import com.example.moonbaseresearchmanagement.transport.Transport;

import jakarta.persistence.*;

@Entity
@Table(name = "rocket")
public class Rocket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rocket_id")
    private int rocketId;

    @OneToMany(mappedBy = "rocket")
    private List<Transport> listTransports;

}
