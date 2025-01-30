package com.misfitpoets.sparkservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sparkserviceController {

    @GetMapping("/api/spark-service/health")
    public String healthCheck() {
        return "spark-service is up!";
    }
}
