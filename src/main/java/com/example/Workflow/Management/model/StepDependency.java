package com.example.Workflow.Management.model;

import jakarta.persistence.*;

@Entity
public class StepDependency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDep")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IdStep" , nullable=false)
    private C_WorkflowSteps step;

    @ManyToOne
    @JoinColumn(name = "IdPredecessor")
    private C_WorkflowSteps pred;

    @ManyToOne
    @JoinColumn(name = "IdSuccessor")
    private C_WorkflowSteps succ;


    ////////////////////////////////
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public C_WorkflowSteps getStep() {
        return step;
    }

    public void setStep(C_WorkflowSteps step) {
        this.step = step;
    }

    public C_WorkflowSteps getPredecessor() {
        return pred;
    }

    public void setPredecessor(C_WorkflowSteps pred) {
        this.pred = pred;
    }

    public C_WorkflowSteps getSuccessor() {
        return succ;
    }

    public void setSuccessor(C_WorkflowSteps succ) {
        this.succ = succ;
    }
}

