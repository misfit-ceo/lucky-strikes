// MarketingService.java
// Location: misfitpoets/misfitpoets-backend/marketing-service/src/main/java/com/misfitpoets/marketingservice/services/MarketingService.java
package com.misfitpoets.marketingservice.services;

import com.misfitpoets.marketingservice.models.Referral;
import com.misfitpoets.marketingservice.repositories.ReferralRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarketingService {

    private final ReferralRepository referralRepository;

    public MarketingService(ReferralRepository referralRepository) {
        this.referralRepository = referralRepository;
    }

    /**
     * Tracks a referral click by incrementing the click count for the given referrer code.
     *
     * @param referrerCode The unique referral code.
     * @return The updated Referral record.
     */
    public Referral trackReferralClick(String referrerCode) {
        Referral referral = referralRepository.findByReferrerCode(referrerCode)
                .orElse(new Referral(referrerCode, 0, 0));
        referral.setClickCount(referral.getClickCount() + 1);
        return referralRepository.save(referral);
    }

    /**
     * Tracks a conversion event (e.g., a signup or purchase) for the given referral code.
     *
     * @param referrerCode The unique referral code.
     * @return The updated Referral record.
     */
    public Referral trackReferralConversion(String referrerCode) {
        Referral referral = referralRepository.findByReferrerCode(referrerCode)
                .orElse(new Referral(referrerCode, 0, 0));
        referral.setConversionCount(referral.getConversionCount() + 1);
        return referralRepository.save(referral);
    }

    /**
     * Retrieves statistics for an influencer/affiliate by their referral code.
     *
     * @param referrerCode The unique referral code.
     * @return The Referral record containing stats.
     */
    public Optional<Referral> getInfluencerStats(String referrerCode) {
        return referralRepository.findByReferrerCode(referrerCode);
    }
}
