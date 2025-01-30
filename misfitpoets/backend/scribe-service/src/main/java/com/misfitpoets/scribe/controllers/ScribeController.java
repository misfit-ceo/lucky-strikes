package com.misfitpoets.scribe.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScribeController {

    @GetMapping("/api/scribe/health")
    public String healthCheck() {
        return "scribe-service is up!";
    }
}
