// Prompt.java
// Location: misfitpoets/misfitpoets-backend/spark-service/src/main/java/com/misfitpoets/sparkservice/models/Prompt.java
package com.misfitpoets.sparkservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prompt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String theme;
    private String tone;
    private String text; // The generated prompt text

    public Prompt() {
    }

    public Prompt(String theme, String tone, String text) {
        this.theme = theme;
        this.tone = tone;
        this.text = text;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
