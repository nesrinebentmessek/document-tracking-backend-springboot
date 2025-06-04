package com.example.Workflow.Management.service;

import com.example.Workflow.Management.model.StepDependency;
import com.example.Workflow.Management.repository.StepDependencyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StepDependencyService {
    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private StepDependencyRepository stepDependencyRepository;

    //////GET
    public List<StepDependency> getAllDependencies() {
        return stepDependencyRepository.findAll();
    }

    public Optional<StepDependency> getDepById(Long id) {
        return stepDependencyRepository.findById(id);
    }


    /////POST
    @Transactional
    public StepDependency saveStepDependency(StepDependency stepDependency) {
        return stepDependencyRepository.save(stepDependency);
    }

    ////DELETE
    public boolean deleteDependencybyID(long id) {
        if (stepDependencyRepository.existsById(id)) {
            stepDependencyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    ////UPDATE
    public StepDependency updateStepDependency(Long id, StepDependency updatedStepDependency) {

        Optional<StepDependency> Dep = stepDependencyRepository.findById(id);
        if (Dep.isPresent()) {
            StepDependency currentStepDependency = Dep.get();
            currentStepDependency.setStep(updatedStepDependency.getStep());
            currentStepDependency.setPredecessor(updatedStepDependency.getPredecessor());
            currentStepDependency.setSuccessor(updatedStepDependency.getSuccessor());

            return stepDependencyRepository.save(currentStepDependency);
        } else {
            throw new EntityNotFoundException("Workflow with ID " + id + " not found.");
        }

    }

}
