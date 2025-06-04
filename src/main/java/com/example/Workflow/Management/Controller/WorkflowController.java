package com.example.Workflow.Management.Controller;
import com.example.Workflow.Management.model.A_Workflow;
import com.example.Workflow.Management.service.WorkflowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/workflow")
public class WorkflowController {

    @Autowired
    private WorkflowService workflowService;

    @GetMapping
    public List<A_Workflow> getAllWorkflows() {
        return workflowService.getAllWorkflows();
    }
    @GetMapping("/{id}")
    public Optional<A_Workflow> getWorkflowById(@PathVariable Long id) {return workflowService.getWorkflowById(id);}








}

