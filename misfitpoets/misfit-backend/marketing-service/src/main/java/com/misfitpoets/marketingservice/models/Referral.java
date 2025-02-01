// Referral.java
// Location: misfitpoets/misfitpoets-backend/marketing-service/src/main/java/com/misfitpoets/marketingservice/models/Referral.java
package com.misfitpoets.marketingservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Referral {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String referrerCode;   // Unique code for the affiliate/influencer
    private int clickCount;
    private int conversionCount;
    
    // Optionally, add fields like commissionEarned, lastUpdated, etc.

    public Referral() {
    }

    public Referral(String referrerCode, int clickCount, int conversionCount) {
        this.referrerCode = referrerCode;
        this.clickCount = clickCount;
        this.conversionCount = conversionCount;
    }

    // Getters and Setters
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getReferrerCode() {
        return referrerCode;
    }

    public void setReferrerCode(String referrerCode) {
        this.referrerCode = referrerCode;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    public int getConversionCount() {
        return conversionCount;
    }

    public void setConversionCount(int conversionCount) {
        this.conversionCount = conversionCount;
    }
}
