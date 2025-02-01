package com.misfitpoets.scrappyscraps.domain;

import javax.persistence.*;

@Entity
@Table(name = "scrap_entries")
public class ScrapEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;        // e.g. "New Agent Announcement"
    @Column(length = 2000)
    private String summary;      // short text
    private String sourceUrl;    // the link where we found it
    private String externalId;   // if we want to track references or item IDs
    private String category;     // e.g. "AGENT_NEWS", "MARKET_TREND"

    // Timestamps, etc. if needed

    // Constructors, getters, setters
}
