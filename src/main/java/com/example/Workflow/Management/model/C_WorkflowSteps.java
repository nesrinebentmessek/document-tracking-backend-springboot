package com.example.Workflow.Management.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "WorkflowSteps")
public class C_WorkflowSteps {

    @ManyToOne
    @JoinColumn(name = "IdWorkflow", nullable = false)
    private A_Workflow workflow;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdStep")
    private long id;


    @Column(name = "StepName")
    private String stepName;
    @Column(name = "Description")
    private String description;
    @Column(name = "Duration")
    private Integer duration;


    /////////////////////////////////////////
    public long getIdStep() {
        return id;
    }

    public void setIdStep(long id) {
        this.id = id;
    }

    ////////////////////////////////////////
    public A_Workflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(A_Workflow workflow) {
        this.workflow = workflow;
    }

    ////////////////////////////////////////
    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    ////////////////////////////////////////
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /////////////////////////////////////////
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /////////////////////////////////////////

}
