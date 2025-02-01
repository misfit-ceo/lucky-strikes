// FileRecord.java
// Location: misfitpoets/misfitpoets-backend/vault-service/src/main/java/com/misfitpoets/vaultservice/models/FileRecord.java
package com.misfitpoets.vaultservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FileRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String fileName;
    private String fileType;
    private String fileUrl; // URL where the file is stored (could be a CDN or cloud storage URL)
    
    // Optionally add fields such as uploadDate, size, encryptionStatus, etc.

    public FileRecord() {
    }

    public FileRecord(String fileName, String fileType, String fileUrl) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileUrl = fileUrl;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }
    
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileUrl() {
        return fileUrl;
    }
    
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
