package com.example.moonbaseresearchmanagement.moonresearcher;

import java.util.List;

import com.example.moonbaseresearchmanagement.base.Base;
import com.example.moonbaseresearchmanagement.personnel.Personnel;
import com.example.moonbaseresearchmanagement.transport.Transport;

import jakarta.persistence.*;

@Entity
@Table(name = "moon_researcher")
public class MoonResearcher extends Personnel {
    private String jobTitle;

    public MoonResearcher() {
        super();
    }

    @ManyToOne
    @JoinColumn(name = "base_id")
    private Base base;

    @ManyToMany
    @JoinTable(
        name = "travels_by",
        joinColumns = @JoinColumn(name = "personnel_id"),
        inverseJoinColumns = @JoinColumn(name = "transport_id")
    )
    private List<Transport> listTransports;
}
