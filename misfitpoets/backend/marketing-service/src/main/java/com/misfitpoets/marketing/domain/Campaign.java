package com.misfitpoets.marketing.domain;

import javax.persistence.*;

@Entity
@Table(name = "campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String campaignName;
    private String authorId;  // which writer or brand
    private String message;   // email or marketing text
    private String status;    // "DRAFT", "LAUNCHED", "COMPLETED"

    // Additional fields, e.g. channel preference, audience segment, etc.

    // Constructors, getters, setters
}
