package com.example.Workflow.Management.Controller;


import com.example.Workflow.Management.model.C_WorkflowSteps;
import com.example.Workflow.Management.service.WorkflowStepsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/workflowSteps")
public class WorkflowStepsController {
    @Autowired
    private WorkflowStepsService workflowStepsService;

    @GetMapping
    public List<C_WorkflowSteps> getAllWorkflowsStep() {
        return workflowStepsService.getAllWorkflowSteps();
    }
    @GetMapping("/{id}")
    public Optional<C_WorkflowSteps> getWorkflowStepById(@PathVariable Long id) {return workflowStepsService.getWorkflowStepById(id);}
}
