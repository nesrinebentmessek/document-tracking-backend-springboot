package com.example.Workflow.Management.repository;

import com.example.Workflow.Management.model.C_WorkflowSteps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowStepsRepository  extends JpaRepository<C_WorkflowSteps, Long> {
    C_WorkflowSteps findByStepName(String stepName);
}
