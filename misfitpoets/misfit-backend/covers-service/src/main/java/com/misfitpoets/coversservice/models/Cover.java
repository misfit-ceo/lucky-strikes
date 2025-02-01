// Cover.java
// Location: misfitpoets/misfitpoets-backend/covers-service/src/main/java/com/misfitpoets/coversservice/models/Cover.java
package com.misfitpoets.coversservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cover {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String bookTitle;
    private String genre;
    private String designUrl; // URL to the generated cover image

    public Cover() {
    }

    public Cover(String bookTitle, String genre, String designUrl) {
        this.bookTitle = bookTitle;
        this.genre = genre;
        this.designUrl = designUrl;
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

    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDesignUrl() {
        return designUrl;
    }
    
    public void setDesignUrl(String designUrl) {
        this.designUrl = designUrl;
    }
}
