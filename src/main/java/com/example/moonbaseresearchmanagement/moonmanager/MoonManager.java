package com.example.moonbaseresearchmanagement.moonmanager;

import java.util.List;

import com.example.moonbaseresearchmanagement.project.Project;

import jakarta.persistence.*;

@Entity
@Table(name = "moon_manager")
public class MoonManager {

    @OneToMany(mappedBy = "moonManager")
    private List<Project> managesProjects;
}
