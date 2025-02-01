// BookRecord.java
// Location: misfitpoets/misfitpoets-backend/aggregator-service/src/main/java/com/misfitpoets/aggregatorservice/models/BookRecord.java
package com.misfitpoets.aggregatorservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookRecord {
    @Id
    private String id;
    private String title;
    private String author;
    // Additional fields, constructors, getters, and setters omitted for brevity
}
