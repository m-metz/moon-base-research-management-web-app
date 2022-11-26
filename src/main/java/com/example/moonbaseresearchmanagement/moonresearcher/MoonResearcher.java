package com.example.moonbaseresearchmanagement.moonresearcher;

import com.example.moonbaseresearchmanagement.personnel.Personnel;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "moon_reseracher")
public class MoonResearcher extends Personnel {
    private String jobTitle;

    private int baseId;
}
