package com.misfitpoets.coverdesign.domain;

import javax.persistence.*;

@Entity
@Table(name = "cover_tasks")
public class CoverTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookTitle;      // from user or from Scribe
    private String authorId;       // which user
    private String styleDescription; // e.g. "Fantasy, with dark tones"
    private String status;         // "REQUESTED", "IN_PROGRESS", "DONE"
    private String coverUrl;       // link to generated image or design

    // Constructors, getters, setters
}
