package com.misfitpoets.distributionservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class distributionserviceController {

    @GetMapping("/api/distribution-service/health")
    public String healthCheck() {
        return "distribution-service is up!";
    }
}
