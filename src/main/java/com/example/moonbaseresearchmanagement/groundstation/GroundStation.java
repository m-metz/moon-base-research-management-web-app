package com.example.moonbaseresearchmanagement.groundstation;

import java.util.Set;
import com.example.moonbaseresearchmanagement.earthmanager.EarthManager;
import jakarta.persistence.*;

@Entity
@Table(name = "ground_station")
public class GroundStation {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "ground_station")
    private Set<EarthManager> recordings;
}
