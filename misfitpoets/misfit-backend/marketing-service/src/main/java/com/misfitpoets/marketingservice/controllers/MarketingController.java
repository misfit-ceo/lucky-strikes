// MarketingController.java
// Location: misfitpoets/misfitpoets-backend/marketing-service/src/main/java/com/misfitpoets/marketingservice/controllers/MarketingController.java
package com.misfitpoets.marketingservice.controllers;

import com.misfitpoets.marketingservice.models.Referral;
import com.misfitpoets.marketingservice.services.MarketingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/marketing")
public class MarketingController {

    private final MarketingService marketingService;

    public MarketingController(MarketingService marketingService) {
        this.marketingService = marketingService;
    }

    /**
     * POST /api/marketing/referrals/track
     * Track a referral click for a given referrer code.
     *
     * @param request A JSON object containing "referrerCode".
     * @return The updated Referral record.
     */
    @PostMapping("/referrals/track")
    public Referral trackReferral(@RequestBody ReferralRequest request) {
        return marketingService.trackReferralClick(request.getReferrerCode());
    }

    /**
     * POST /api/marketing/referrals/conversion
     * Track a conversion event for a given referrer code.
     *
     * @param request A JSON object containing "referrerCode".
     * @return The updated Referral record.
     */
    @PostMapping("/referrals/conversion")
    public Referral trackConversion(@RequestBody ReferralRequest request) {
        return marketingService.trackReferralConversion(request.getReferrerCode());
    }

    /**
     * GET /api/marketing/influencers/{referrerCode}/stats
     * Retrieve influencer statistics for the given referrer code.
     *
     * @param referrerCode The unique referral code.
     * @return The Referral record with statistics.
     */
    @GetMapping("/influencers/{referrerCode}/stats")
    public Referral getInfluencerStats(@PathVariable String referrerCode) {
        return marketingService.getInfluencerStats(referrerCode)
                .orElseThrow(() -> new RuntimeException("No stats found for referrer code: " + referrerCode));
    }
    
    // Request DTO for referral tracking
    public static class ReferralRequest {
        private String referrerCode;

        public String getReferrerCode() {
            return referrerCode;
        }

        public void setReferrerCode(String referrerCode) {
            this.referrerCode = referrerCode;
        }
    }
}
