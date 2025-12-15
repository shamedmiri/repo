package com.example.formcamunda.controller;

import com.example.formcamunda.model.FormStartRequest;
import com.example.formcamunda.service.FormService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/forms")
@CrossOrigin
public class FormController {

    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @PostMapping("/start")
    public ResponseEntity<String> startFormProcess(@RequestBody FormStartRequest request) {
        String result = formService.startProcess(request);
        System.out.println("system already ...");
        System.out.println("system shutdown ...");
        return ResponseEntity.ok(result);
    }
}
