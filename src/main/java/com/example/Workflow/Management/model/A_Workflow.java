package com.example.Workflow.Management.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Workflow")
public class A_Workflow {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdWorkflow")
    private Long id;


    @Column(name = "CreePar")
    private String creePar;
    @Column(name = "DateDeCreation")
    private LocalDateTime dateDeCreation;
    @Column(name = "Description")
    private String description;
    @Column(name = "Intitule")
    private String intitule;
    @Column(name = "Reference")
    private String reference;




    //////////////////
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    /////////////////
    public String getCreePar() {return creePar;}
    public void setCreePar(String creePar) {this.creePar = creePar;}
    /////////////////
    public LocalDateTime getDateDeCreation() {return dateDeCreation;}
    public void setDateDeCreation(LocalDateTime dateDeCreation) {this.dateDeCreation = dateDeCreation;}
    /////////////////
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    /////////////////
    public String getIntitule() {return intitule;}
    public void setIntitule(String intitule) {this.intitule = intitule;}
    /////////////////
    public String getReference() {return reference;}
    public void setReference(String reference) {this.reference = reference;}

    ////////////////




}















