package com.example.Workflow.Management.repository;

import com.example.Workflow.Management.model.StepDependency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepDependencyRepository extends JpaRepository<StepDependency, Long> {
}
