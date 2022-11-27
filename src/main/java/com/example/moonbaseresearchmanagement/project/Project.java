package com.example.moonbaseresearchmanagement.project;

import java.util.List;

import com.example.moonbaseresearchmanagement.building.Building;
import com.example.moonbaseresearchmanagement.earthmanager.EarthManager;
import com.example.moonbaseresearchmanagement.moonmanager.MoonManager;
import com.example.moonbaseresearchmanagement.personnel.Personnel;
import com.example.moonbaseresearchmanagement.researchtasks.ResearchTask;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int projectId;

    private String name;


    @ManyToMany(mappedBy = "listProjects")
    private List<Personnel> projectWorkers;

    @ManyToOne
    @JoinColumn(name = "m_manager_id")
    private MoonManager moonManager;

    @ManyToOne
    @JoinColumn(name = "e_manager_id")
    private EarthManager earthManager;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToMany(mappedBy = "project")
    private List<ResearchTask> projectTasks;
}
