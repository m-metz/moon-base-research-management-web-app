package com.example.moonbaseresearchmanagement.researchtasks;

import com.example.moonbaseresearchmanagement.project.Project;

import jakarta.persistence.*;

@Entity
@Table(name = "research_task")
public class ResearchTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int taskId;

    private String title;

    private String notes;

    private String status;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public ResearchTask () {}

    

    public ResearchTask(int taskId, String title, String notes, String status, Project project) {
        this.taskId = taskId;
        this.title = title;
        this.notes = notes;
        this.status = status;
        this.project = project;
    }


    public ResearchTask(String title, String notes, String status, Project project) {
        this.title = title;
        this.notes = notes;
        this.status = status;
        this.project = project;
    }



    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    
}
