package com.misfitpoets.weaveservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class weaveserviceController {

    @GetMapping("/api/weave-service/health")
    public String healthCheck() {
        return "weave-service is up!";
    }
}
