package com.misfitpoets.distribution.domain;

import javax.persistence.*;

@Entity
@Table(name = "distribution_tasks")
public class DistributionTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String manuscriptId;   // reference to the final doc
    private String coverId;        // reference to the final cover
    private String distributionChannel; // e.g. "Amazon KDP", "IngramSpark", "Draft2Digital"
    private String status;         // "REQUESTED", "IN_PROGRESS", "COMPLETED"
    private String resultMessage;  // store success/fail details, or link to listing

    // Constructors, getters, setters
}
