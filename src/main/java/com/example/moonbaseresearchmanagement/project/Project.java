package com.example.moonbaseresearchmanagement.project;

import java.io.Serializable;
import java.util.Set;

import com.example.moonbaseresearchmanagement.personnel.Personnel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name = "project")
public class Project implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int project_id;

    
    @ManyToMany(mappedBy = "listProjects")
    Set<Personnel> projectWorkers;
}
