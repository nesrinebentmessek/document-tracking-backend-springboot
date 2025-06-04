package com.example.Workflow.Management.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "TypeDoc")
public class B_TypeDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTypeDoc")
    private Integer idTypeDoc;

    @Column(name = "Description")
    private String description;

    @Column(name = "Intitule")
    private String intitule;

    @Column(name = "Model_Reference")
    private String modelReference;

    private LocalDateTime dateOfSubmission;
    private int durationLimit;


    @Column(name = "Status")
    private String status;

    @Column(name = "Position_Doc")
    private String positionDoc;

    //@ManyToOne
    //@JoinColumn(name = "IdWorkflow", nullable = false)
    //private A_Workflow workflow;

    // Getters and Setters

    public Integer getIdTypeDoc() {
        return idTypeDoc;
    }

    public void setIdTypeDoc(Integer idTypeDoc) {
        this.idTypeDoc = idTypeDoc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getModelReference() {
        return modelReference;
    }

    public void setModelReference(String modelReference) {
        this.modelReference = modelReference;
    }

    public LocalDateTime getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(LocalDateTime dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }

    public int getDurationLimit() {
        return durationLimit;
    }

    public void setDurationLimit(int durationLimit) {
        this.durationLimit = durationLimit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPositionDoc() {
        return positionDoc;
    }

    public void setPositionDoc(String positionDoc) {
        this.positionDoc = positionDoc;
    }


}

