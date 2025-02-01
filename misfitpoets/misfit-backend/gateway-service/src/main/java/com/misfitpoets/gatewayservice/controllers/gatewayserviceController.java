package com.misfitpoets.gatewayservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class gatewayserviceController {

    @GetMapping("/api/gateway-service/health")
    public String healthCheck() {
        return "gateway-service is up!";
    }
}
