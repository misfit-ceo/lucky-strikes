package com.misfitpoets.aggregator.domain;

import javax.persistence.*;

@Entity
@Table(name = "aggregated_records")
public class AggregatedRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceName;
    private String rawData;

    // Could store JSON or structured text
    @Column(columnDefinition = "TEXT")
    private String processedData;

    // Constructors, getters, setters
}
