package com.example.moonbaseresearchmanagement.moonresearcher;

import com.example.moonbaseresearchmanagement.personnel.Personnel;
import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "moon_reseracher")
public class MoonResearcher extends Personnel {
    @Column(name = "job_title")
    private String job_title;

    @Column(name = "base_id")
    private int base_id;
}
