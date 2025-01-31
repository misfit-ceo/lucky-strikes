package com.misfitpoets.marketing.repositories;

import com.misfitpoets.marketing.domain.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    // Additional queries if needed
}
