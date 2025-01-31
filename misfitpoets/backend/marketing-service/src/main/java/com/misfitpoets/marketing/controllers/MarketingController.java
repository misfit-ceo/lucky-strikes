package com.misfitpoets.marketing.controllers;

import com.misfitpoets.marketing.dto.CampaignRequest;
import com.misfitpoets.marketing.dto.CampaignResponse;
import com.misfitpoets.marketing.services.MarketingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marketing")
public class MarketingController {

    private final MarketingService marketingService;

    public MarketingController(MarketingService marketingService) {
        this.marketingService = marketingService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "marketing-service is up!";
    }

    // 1) Create a new campaign
    @PostMapping("/campaigns")
    public ResponseEntity<CampaignResponse> createCampaign(@RequestBody CampaignRequest request) {
        CampaignResponse resp = marketingService.createCampaign(request);
        return ResponseEntity.ok(resp);
    }

    // 2) List all campaigns
    @GetMapping("/campaigns")
    public ResponseEntity<List<CampaignResponse>> listCampaigns() {
        return ResponseEntity.ok(marketingService.listCampaigns());
    }

    // 3) Get single campaign
    @GetMapping("/campaigns/{id}")
    public ResponseEntity<CampaignResponse> getCampaign(@PathVariable Long id) {
        return ResponseEntity.ok(marketingService.getCampaign(id));
    }

    // 4) Launch campaign
    @PostMapping("/campaigns/{id}/launch")
    public ResponseEntity<CampaignResponse> launchCampaign(@PathVariable Long id) {
        return ResponseEntity.ok(marketingService.launchCampaign(id));
    }

    // 5) Delete a campaign
    @DeleteMapping("/campaigns/{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable Long id) {
        marketingService.deleteCampaign(id);
        return ResponseEntity.noContent().build();
    }
}
