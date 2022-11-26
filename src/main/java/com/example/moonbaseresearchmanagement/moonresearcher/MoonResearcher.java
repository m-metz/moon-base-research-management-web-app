package com.example.moonbaseresearchmanagement.moonresearcher;

import java.util.List;

import com.example.moonbaseresearchmanagement.personnel.Personnel;
import com.example.moonbaseresearchmanagement.transport.Transport;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "moon_researcher")
public class MoonResearcher extends Personnel {
    private String jobTitle;

    private int baseId;

    @ManyToMany
    @JoinTable(
        name = "travels_by", 
        joinColumns = @JoinColumn(name = "personnel_id"), 
        inverseJoinColumns = @JoinColumn(name = "transport_id")
    )
    List<Transport> listTransports;

}
