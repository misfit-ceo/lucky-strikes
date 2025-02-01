// DistributionTask.java
// Location: misfitpoets/misfitpoets-backend/distribution-service/src/main/java/com/misfitpoets/distributionservice/models/DistributionTask.java
package com.misfitpoets.distributionservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DistributionTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String bookTitle;
    private String author;
    private String status; // e.g., "PENDING", "IN_PROGRESS", "COMPLETED"
    private String platform; // e.g., "Amazon KDP", "IngramSpark"

    public DistributionTask() {
    }

    public DistributionTask(String bookTitle, String author, String status, String platform) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.status = status;
        this.platform = platform;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }
    
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlatform() {
        return platform;
    }
    
    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
