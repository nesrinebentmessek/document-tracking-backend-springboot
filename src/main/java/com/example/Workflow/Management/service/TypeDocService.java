package com.example.Workflow.Management.service;
import com.example.Workflow.Management.model.B_TypeDoc;
import com.example.Workflow.Management.model.C_WorkflowSteps;
import com.example.Workflow.Management.repository.WorkflowStepsRepository;






import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.Workflow.Management.repository.TypeDocRepository;

import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Service
public class TypeDocService {

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private TypeDocRepository typeDocRepository;

    @Autowired
    private WorkflowStepsRepository workflowStepRepository;

    @Autowired
    private EmailService emailService;
    private Object String;

    //////GET
    public List<B_TypeDoc> getAllDocs() {
        return typeDocRepository.findAll();
    }
    public Optional<B_TypeDoc> getDocById(Long id) {
        return typeDocRepository.findById(id);
    }





   @Scheduled(fixedRate = 60000)
    public void checkDocumentStatus() {
        List<B_TypeDoc> docs = typeDocRepository.findAll();

        for (B_TypeDoc doc : docs) {
            LocalDateTime deadline = doc.getDateOfSubmission().plusSeconds(doc.getDurationLimit());
            if ("not complete".equals(doc.getStatus())
                    && deadline.isBefore(LocalDateTime.now())) {

                String to = "nesrinebentmessek@gmail.com";
                String subject = "Document Time Limit Exceeded";
                String text = "Document " + doc.getIntitule() + " has surpassed the time limit!!";
                emailService.sendEmail(to, subject, text);

            } else if ("Request Modification".equals(doc.getPositionDoc())) {
                String to = "nesrinebentmessek@gmail.com";
                String subject = "Modification for  " + doc.getIntitule() +" Required";
                String text = "The Data you included in the sent document is not accurate. Please modify it.";
                emailService.sendEmail(to, subject, text);

            } else if ("Manager Approval".equals(doc.getPositionDoc())) {
                String to = "nesrinebentmessek@gmail.com";
                String subject = "Manager Approval";
                String text = "Your " +doc.getIntitule()+" document has been approved by the manager.";
                emailService.sendEmail(to, subject, text);

            } else if (("Complete".equals(doc.getStatus()))){
                String to = "nesrinebentmessek@gmail.com";
                String subject = "Complete";
                String text = "Your " +doc.getIntitule()+" is complete.";
                emailService.sendEmail(to, subject, text);

            }


        }
    }


    @Scheduled(fixedRate = 60000)
    public void checkDocumentAndSendEmail() {
        List<B_TypeDoc> docs = typeDocRepository.findAll();

        for (B_TypeDoc doc : docs) {
            String docPosition = doc.getPositionDoc();
            C_WorkflowSteps workflowStep = workflowStepRepository.findByStepName(docPosition);
            if (workflowStep != null) {
                LocalDateTime deadline = doc.getDateOfSubmission().plusSeconds(workflowStep.getDuration());
                if (deadline.isBefore(LocalDateTime.now())) {
                    String to = "nesrinebentmessek@gmail.com";
                    String subject = "Document Deadline Exceeded";
                    String text = "Document " + doc.getIntitule() + " has exceeded the deadline for step: " + workflowStep.getStepName();
                    emailService.sendEmail(to, subject, text);
                }
            }
        }
    }










    /////POST
    @Transactional
    public B_TypeDoc saveDoc( B_TypeDoc typeDoc) {
        return typeDocRepository.save(typeDoc);

    }

    ////DELETE
    public boolean deleteDocbyID(long id){
        if(typeDocRepository.existsById(id)) {
            typeDocRepository.deleteById(id);
            return true;
        }else{return false;}
    }
    ///////////////////










    ////UPDATE












    }













