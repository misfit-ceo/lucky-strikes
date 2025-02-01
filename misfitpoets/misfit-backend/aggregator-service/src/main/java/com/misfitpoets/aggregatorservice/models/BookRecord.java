// BookRecord.java
// Location: misfitpoets/misfitpoets-backend/aggregator-service/src/main/java/com/misfitpoets/aggregatorservice/models/BookRecord.java
package com.misfitpoets.aggregatorservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String title;
    private String author;
    private String source;   // e.g., "Google Books", "Project Gutenberg"
    private String description;

    public BookRecord() {
    }

    public BookRecord(String title, String author, String source, String description) {
        this.title = title;
        this.author = author;
        this.source = source;
        this.description = description;
    }

    // Getters and Setters
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}
