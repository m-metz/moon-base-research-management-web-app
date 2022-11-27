package com.example.moonbaseresearchmanagement.moonresearcher;

import java.util.List;

import com.example.moonbaseresearchmanagement.base.Base;
import com.example.moonbaseresearchmanagement.personnel.Personnel;
import com.example.moonbaseresearchmanagement.project.Project;
import com.example.moonbaseresearchmanagement.transport.Transport;

import jakarta.persistence.*;

@Entity
@Table(name = "moon_researcher")
public class MoonResearcher extends Personnel {
    private String jobTitle;

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

    
    public MoonResearcher() {
        super();
    }


    public MoonResearcher(int personnelId, String name, String country, String jobTitle, Base base) {
        super(personnelId, name, country);
        this.jobTitle = jobTitle;
        this.base = base;
    }



    public MoonResearcher(String name, String country, String jobTitle, Base base) {
        super(name, country);
        this.jobTitle = jobTitle;
        this.base = base;
    }
    
    public MoonResearcher(int personnelId, String name, String country, String jobTitle, Base base,
            List<Transport> listTransports) {
        super(personnelId, name, country);
        this.jobTitle = jobTitle;
        this.base = base;
        this.listTransports = listTransports;
    }


    public MoonResearcher(String name, String country, String jobTitle, Base base, List<Transport> listTransports) {
        super(name, country);
        this.jobTitle = jobTitle;
        this.base = base;
        this.listTransports = listTransports;
    }


    public MoonResearcher(int personnelId, String name, String country, List<Project> listProjects, String jobTitle,
            Base base) {
        super(personnelId, name, country, listProjects);
        this.jobTitle = jobTitle;
        this.base = base;
    }

    
    public MoonResearcher(String name, String country, List<Project> listProjects, String jobTitle, Base base) {
        super(name, country, listProjects);
        this.jobTitle = jobTitle;
        this.base = base;
    }


    public MoonResearcher(int personnelId, String name, String country, List<Project> listProjects, String jobTitle,
            Base base, List<Transport> listTransports) {
        super(personnelId, name, country, listProjects);
        this.jobTitle = jobTitle;
        this.base = base;
        this.listTransports = listTransports;
    }

    public MoonResearcher(String name, String country, List<Project> listProjects, String jobTitle, Base base,
            List<Transport> listTransports) {
        super(name, country, listProjects);
        this.jobTitle = jobTitle;
        this.base = base;
        this.listTransports = listTransports;
    }


    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public List<Transport> getListTransports() {
        return listTransports;
    }

    public void setListTransports(List<Transport> listTransports) {
        this.listTransports = listTransports;
    }
}