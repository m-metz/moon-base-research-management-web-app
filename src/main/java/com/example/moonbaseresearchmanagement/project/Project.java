package com.example.moonbaseresearchmanagement.project;

import java.util.List;

import com.example.moonbaseresearchmanagement.personnel.Personnel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name = "project")
public class Project{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int projectId;

    
    @ManyToMany(mappedBy = "listProjects")
    List<Personnel> projectWorkers;
}
