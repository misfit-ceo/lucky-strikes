package com.misfitpoets.scrappyscrapsservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class scrappyscrapsserviceController {

    @GetMapping("/api/scrappy-scraps-service/health")
    public String healthCheck() {
        return "scrappy-scraps-service is up!";
    }
}
