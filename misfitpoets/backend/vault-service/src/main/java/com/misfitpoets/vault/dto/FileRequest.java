package com.misfitpoets.vault.dto;

public class FileRequest {
    private String fileName;
    private String contentType;
    private String ownerId;
    private String storedFormat;

    // Not storing the file data directly here
    // because we typically handle file bytes with MultipartFile

    // getters, setters
}
