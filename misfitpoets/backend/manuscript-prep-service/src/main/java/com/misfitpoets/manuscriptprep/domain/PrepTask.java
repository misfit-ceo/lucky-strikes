package com.misfitpoets.manuscriptprep.domain;

import javax.persistence.*;

@Entity
@Table(name = "prep_tasks")
public class PrepTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String docTitle;        // e.g. "Chapter 1"
    @Column(length = 2000)
    private String docContent;      // raw text or snippet
    private String ownerId;         // who requested the prep
    private String status;          // e.g. "PENDING", "IN_PROGRESS", "COMPLETE"
    private String outputFormat;    // e.g. "DOCX", "PDF"

    // Constructors, getters, setters
}
