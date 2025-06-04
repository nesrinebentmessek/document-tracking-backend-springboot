package com.example.Workflow.Management.service;
import com.example.Workflow.Management.model.A_Workflow;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.Workflow.Management.repository.WorkflowRepository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


@Service
    public class WorkflowService {

    @Autowired
    private WorkflowRepository workflowRepository;

    //////GET
    public List<A_Workflow> getAllWorkflows() {
        return workflowRepository.findAll();
    }

    public Optional<A_Workflow> getWorkflowById(Long id) {
        return workflowRepository.findById(id);
    }

    //////////////////
    public boolean existsById(Long id) {
        return workflowRepository.existsById(id);
    }
    /////////////////////

    /////POST
    public A_Workflow saveWorkflow(A_Workflow workflow) {
        return workflowRepository.save(workflow);
    }

    ////DELETE
    public boolean deleteworkflowbyID(long id){
        if(workflowRepository.existsById(id)) {
            workflowRepository.deleteById(id);
            return true;
        }else{return false;}
    }
    ////UPDATE
    @Transactional
    public A_Workflow updateWorkflow(Long Id , A_Workflow updatedWorkflow) {
        Optional<A_Workflow> Work = workflowRepository.findById(Id);
        if (Work.isPresent()) {
            A_Workflow currentworkflow = Work.get();

            currentworkflow.setCreePar(updatedWorkflow.getCreePar());
            currentworkflow.setDateDeCreation(updatedWorkflow.getDateDeCreation());
            currentworkflow.setDescription(updatedWorkflow.getDescription());
            currentworkflow.setIntitule(updatedWorkflow.getIntitule());
            currentworkflow.setReference(updatedWorkflow.getReference());

            return workflowRepository.save(currentworkflow);}
        else {
            throw new EntityNotFoundException("Workflow with ID " + Id + " not found.");
        }
    }




    }


