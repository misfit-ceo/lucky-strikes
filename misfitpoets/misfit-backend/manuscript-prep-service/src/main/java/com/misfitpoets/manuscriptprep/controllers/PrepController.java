package com.misfitpoets.manuscriptprepservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class manuscriptprepserviceController {

    @GetMapping("/api/manuscript-prep-service/health")
    public String healthCheck() {
        return "manuscript-prep-service is up!";
    }
}
