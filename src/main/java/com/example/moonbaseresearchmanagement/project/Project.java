package com.example.moonbaseresearchmanagement.project;

import java.util.ArrayList;
import java.util.List;

import com.example.moonbaseresearchmanagement.building.Building;
import com.example.moonbaseresearchmanagement.earthmanager.EarthManager;
import com.example.moonbaseresearchmanagement.moonmanager.MoonManager;
import com.example.moonbaseresearchmanagement.personnel.Personnel;
import com.example.moonbaseresearchmanagement.researchtasks.ResearchTask;

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
    private List<ResearchTask> projectTasks =new ArrayList<>();

    public Project (){}


    public Project(int projectId, String name) {
        this.projectId = projectId;
        this.name = name;
    }


    public Project(String name) {
        this.name = name;
    }


    public Project(String name, List<Personnel> projectWorkers, MoonManager moonManager, EarthManager earthManager,
            Building building, List<ResearchTask> projectTasks) {
        this.name = name;
        this.projectWorkers = projectWorkers;
        this.moonManager = moonManager;
        this.earthManager = earthManager;
        this.building = building;
        this.projectTasks = projectTasks;
    }


    public Project(int projectId, String name, List<Personnel> projectWorkers, MoonManager moonManager,
            EarthManager earthManager, Building building, List<ResearchTask> projectTasks) {
        this.projectId = projectId;
        this.name = name;
        this.projectWorkers = projectWorkers;
        this.moonManager = moonManager;
        this.earthManager = earthManager;
        this.building = building;
        this.projectTasks = projectTasks;
    }


    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Personnel> getProjectWorkers() {
        return projectWorkers;
    }

    public void setProjectWorkers(List<Personnel> projectWorkers) {
        this.projectWorkers = projectWorkers;
    }

    public MoonManager getMoonManager() {
        return moonManager;
    }

    public void setMoonManager(MoonManager moonManager) {
        this.moonManager = moonManager;
    }

    public EarthManager getEarthManager() {
        return earthManager;
    }

    public void setEarthManager(EarthManager earthManager) {
        this.earthManager = earthManager;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public List<ResearchTask> getProjectTasks() {
        return projectTasks;
    }

    public void setProjectTasks(List<ResearchTask> projectTasks) {
        this.projectTasks = projectTasks;
    }
}