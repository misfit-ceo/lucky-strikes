package com.misfitpoets.vaultservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class vaultserviceController {

    @GetMapping("/api/vault-service/health")
    public String healthCheck() {
        return "vault-service is up!";
    }
}
