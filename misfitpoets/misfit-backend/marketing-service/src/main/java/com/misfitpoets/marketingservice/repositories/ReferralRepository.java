// ReferralRepository.java
// Location: misfitpoets/misfitpoets-backend/marketing-service/src/main/java/com/misfitpoets/marketingservice/repositories/ReferralRepository.java
package com.misfitpoets.marketingservice.repositories;

import com.misfitpoets.marketingservice.models.Referral;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReferralRepository extends JpaRepository<Referral, Long> {
    Optional<Referral> findByReferrerCode(String referrerCode);
}
