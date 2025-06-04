package com.example.Workflow.Management.repository;
import com.example.Workflow.Management.model.A_Workflow;

import org.springframework.data.jpa.repository.JpaRepository;


public interface WorkflowRepository extends JpaRepository<A_Workflow, Long> {


}
