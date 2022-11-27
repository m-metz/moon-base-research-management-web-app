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
}
