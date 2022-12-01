package com.example.moonbaseresearchmanagement.moonmanager;

import java.util.ArrayList;
import java.util.List;

import com.example.moonbaseresearchmanagement.base.Base;
import com.example.moonbaseresearchmanagement.moonresearcher.MoonResearcher;
import com.example.moonbaseresearchmanagement.project.Project;
import com.example.moonbaseresearchmanagement.transport.Transport;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "moon_manager")
public class MoonManager extends MoonResearcher {
    
    @JsonIgnore
    @OneToMany(mappedBy = "moonManager", orphanRemoval = true)
    private List<Project> managesProjects = new ArrayList<>();

    public MoonManager(){
        super();
    }


    public MoonManager(int personnelId, String name, String country, String jobTitle, Base base) {
        super(personnelId, name, country, jobTitle, base);
    }    
    

    public MoonManager(String name, String country, String jobTitle, Base base) {
        super(name, country, jobTitle, base);
    }


    public MoonManager(int personnelId, String name, String country, String jobTitle, Base base,
            List<Transport> listTransports) {
        super(personnelId, name, country, jobTitle, base, listTransports);
    }


    public MoonManager(String name, String country, String jobTitle, Base base, List<Transport> listTransports) {
        super(name, country, jobTitle, base, listTransports);
    }


    public MoonManager(int personnelId, String name, String country, String jobTitle, Base base,
            List<Transport> listTransports, List<Project> managesProjects) {
        super(personnelId, name, country, jobTitle, base, listTransports);
        this.managesProjects = managesProjects;
    }


    public MoonManager(String name, String country, String jobTitle, Base base, List<Transport> listTransports,
            List<Project> managesProjects) {
        super(name, country, jobTitle, base, listTransports);
        this.managesProjects = managesProjects;
    }

    

    public MoonManager(int personnelId, String name, String country, List<Project> listProjects, String jobTitle,
            Base base) {
        super(personnelId, name, country, listProjects, jobTitle, base);
    }


    public MoonManager(String name, String country, List<Project> listProjects, String jobTitle, Base base) {
        super(name, country, listProjects, jobTitle, base);
    }


    public MoonManager(int personnelId, String name, String country, List<Project> listProjects, String jobTitle,
            Base base, List<Transport> listTransports) {
        super(personnelId, name, country, listProjects, jobTitle, base, listTransports);
    }


    public MoonManager(String name, String country, List<Project> listProjects, String jobTitle, Base base,
            List<Transport> listTransports) {
        super(name, country, listProjects, jobTitle, base, listTransports);
    }


    public MoonManager(int personnelId, String name, String country, List<Project> listProjects, String jobTitle,
            Base base, List<Transport> listTransports, List<Project> managesProjects) {
        super(personnelId, name, country, listProjects, jobTitle, base, listTransports);
        this.managesProjects = managesProjects;
    }


    public MoonManager(String name, String country, List<Project> listProjects, String jobTitle, Base base,
            List<Transport> listTransports, List<Project> managesProjects) {
        super(name, country, listProjects, jobTitle, base, listTransports);
        this.managesProjects = managesProjects;
    }


    public List<Project> getManagesProjects() {
        return managesProjects;
    }

    public void setManagesProjects(List<Project> managesProjects) {
        this.managesProjects = managesProjects;
    }

    public void addManagedProject(Project project) {
        managesProjects.add(project);
        project.setMoonManager(this);
    }

    public void removeManagedProject(Project project) {
        managesProjects.remove(project);
        project.setMoonManager(null);
    }

    public void removeAllManagedprojects(){
        Project project =null;
        int size = managesProjects.size();
        for (int i =0; i < size; i++){
            project = managesProjects.get(0);
            managesProjects.remove(project);
            project.setMoonManager(null);
        }
    }

    public int numManagedProjects() {

        return managesProjects.size();
    }


    public Project getManagedProject(int i) {
        return managesProjects.get(i);
    }

    




}
