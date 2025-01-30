package com.misfitpoets.coverdesignservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class coverdesignserviceController {

    @GetMapping("/api/cover-design-service/health")
    public String healthCheck() {
        return "cover-design-service is up!";
    }
}
