package com.example.moonbaseresearchmanagement.groundstation;

import com.example.moonbaseresearchmanagement.earthmanager.EarthManager;
import java.io.Serializable;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "ground_station")
public class GroundStation implements Serializable {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "ground_station")
    private Set<EarthManager> recordings;
}
