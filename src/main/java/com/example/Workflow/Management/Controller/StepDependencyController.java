package com.example.Workflow.Management.Controller;



import com.example.Workflow.Management.model.StepDependency;
import com.example.Workflow.Management.service.StepDependencyService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/stepDep")
public class StepDependencyController {

    @Autowired
    private StepDependencyService stepDependancyService;

    @GetMapping
    public List<StepDependency> getAllWorkflows() {
        return stepDependancyService.getAllDependencies();
    }
    @GetMapping("/{id}")
    public Optional<StepDependency> getWorkflowById(@PathVariable Long id) {return stepDependancyService.getDepById(id);}

}
