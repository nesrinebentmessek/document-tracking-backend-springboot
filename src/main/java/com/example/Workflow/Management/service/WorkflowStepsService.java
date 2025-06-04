package com.example.Workflow.Management.service;
import com.example.Workflow.Management.model.C_WorkflowSteps;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Workflow.Management.repository.WorkflowStepsRepository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


@Service
public class WorkflowStepsService {

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private WorkflowStepsRepository workflowStepsRepository;

    //////GET
    public List<C_WorkflowSteps> getAllWorkflowSteps() {
        return workflowStepsRepository.findAll();
    }
    public Optional<C_WorkflowSteps> getWorkflowStepById(Long id) {
        return workflowStepsRepository.findById(id);
    }










    /////POST
    @Transactional
    public C_WorkflowSteps saveWorkflowStep(C_WorkflowSteps workflowSteps) {
        Long workflowId = workflowSteps.getWorkflow().getId();
        if (workflowService.existsById(workflowId)) {
            return workflowStepsRepository.save(workflowSteps);
        } else {
            throw new EntityNotFoundException("Workflow with id " + workflowId + " not found");
        }
    }

    ////DELETE
    public boolean deleteworkflowStepbyID(long id){
        if(workflowStepsRepository.existsById(id)) {
            workflowStepsRepository.deleteById(id);
            return true;
        }else{return false;}
    }

    ////UPDATE
    @Transactional
    public C_WorkflowSteps updateWorkflowStep(Long Id , C_WorkflowSteps updatedWorkflowStep) {
        Optional<C_WorkflowSteps> Work = workflowStepsRepository.findById(Id);
        if (Work.isPresent()) {
            C_WorkflowSteps currentworkflowstep = Work.get();

            Long workflowId = updatedWorkflowStep.getWorkflow().getId();
            if (workflowId != null && workflowService.existsById(workflowId)){
                currentworkflowstep.setWorkflow(updatedWorkflowStep.getWorkflow());
            }
            currentworkflowstep.setStepName(updatedWorkflowStep.getStepName());
            currentworkflowstep.setDescription(updatedWorkflowStep.getDescription());
            currentworkflowstep.setDuration(updatedWorkflowStep.getDuration());


            return workflowStepsRepository.save(currentworkflowstep);}
        else {
            throw new EntityNotFoundException("Workflow with ID " + Id + " not found.");
        }
    }









}


