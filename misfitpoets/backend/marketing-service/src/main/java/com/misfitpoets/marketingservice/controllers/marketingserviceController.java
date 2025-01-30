package com.misfitpoets.marketingservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class marketingserviceController {

    @GetMapping("/api/marketing-service/health")
    public String healthCheck() {
        return "marketing-service is up!";
    }
}
