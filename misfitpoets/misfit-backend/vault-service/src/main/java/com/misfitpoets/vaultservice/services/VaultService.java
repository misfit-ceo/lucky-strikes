// VaultService.java
// Location: misfitpoets/misfitpoets-backend/vault-service/src/main/java/com/misfitpoets/vaultservice/services/VaultService.java
package com.misfitpoets.vaultservice.services;

import com.misfitpoets.vaultservice.models.FileRecord;
import com.misfitpoets.vaultservice.repositories.FileRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VaultService {

    private final FileRecordRepository fileRecordRepository;

    public VaultService(FileRecordRepository fileRecordRepository) {
        this.fileRecordRepository = fileRecordRepository;
    }

    /**
     * Simulate file upload by saving file metadata.
     * In production, this would include file storage (e.g., AWS S3) and secure access.
     *
     * @param fileName The name of the file.
     * @param fileType The file type (e.g., "pdf", "docx").
     * @return The created FileRecord.
     */
    public FileRecord uploadFile(String fileName, String fileType) {
        // Simulate generating a file URL
        String fileUrl = "https://cdn.misfitpoets.com/vault/" + fileName.replaceAll("\\s+", "_");
        FileRecord record = new FileRecord(fileName, fileType, fileUrl);
        return fileRecordRepository.save(record);
    }

    /**
     * Retrieve a file record by its ID.
     *
     * @param id The file record ID.
     * @return An Optional containing the FileRecord if found.
     */
    public Optional<FileRecord> getFileById(Long id) {
        return fileRecordRepository.findById(id);
    }

    /**
     * Retrieve all file records.
     *
     * @return List of FileRecord objects.
     */
    public List<FileRecord> getAllFiles() {
        return fileRecordRepository.findAll();
    }
}
