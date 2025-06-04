package com.example.Workflow.Management.Controller;



import com.example.Workflow.Management.model.B_TypeDoc;
import com.example.Workflow.Management.service.TypeDocService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/typeDoc")

public class TypeDocController {

    @Autowired
    private TypeDocService typeDocService;

    @GetMapping
    public List<B_TypeDoc> getAllDocs() {
        return typeDocService.getAllDocs();
    }
    @PostMapping
    public B_TypeDoc createWorkflow(@RequestBody B_TypeDoc doc) {
        doc.setDateOfSubmission(LocalDateTime.now());
        return typeDocService.saveDoc(doc);
    }
    @GetMapping("/check-status")
    public String checkStatus() {
        typeDocService.checkDocumentStatus();
        return "Document status checked";
    }










   }

