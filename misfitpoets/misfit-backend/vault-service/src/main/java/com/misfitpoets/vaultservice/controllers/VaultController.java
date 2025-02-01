// VaultController.java
// Location: misfitpoets/misfitpoets-backend/vault-service/src/main/java/com/misfitpoets/vaultservice/controllers/VaultController.java
package com.misfitpoets.vaultservice.controllers;

import com.misfitpoets.vaultservice.models.FileRecord;
import com.misfitpoets.vaultservice.services.VaultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vault")
public class VaultController {

    private final VaultService vaultService;

    public VaultController(VaultService vaultService) {
        this.vaultService = vaultService;
    }

    /**
     * POST /api/vault/upload
     * Simulate uploading a file by storing file metadata.
     *
     * @param request A JSON object containing "fileName" and "fileType".
     * @return The created FileRecord.
     */
    @PostMapping("/upload")
    public FileRecord uploadFile(@RequestBody FileUploadRequest request) {
        return vaultService.uploadFile(request.getFileName(), request.getFileType());
    }

    /**
     * GET /api/vault/download/{id}
     * Retrieve file metadata (simulate file download).
     *
     * @param id The file record ID.
     * @return The FileRecord if found.
     */
    @GetMapping("/download/{id}")
    public FileRecord downloadFile(@PathVariable Long id) {
        return vaultService.getFileById(id)
                .orElseThrow(() -> new RuntimeException("File not found with id " + id));
    }

    /**
     * GET /api/vault/files
     * Retrieve all file records.
     *
     * @return List of FileRecord objects.
     */
    @GetMapping("/files")
    public List<FileRecord> getAllFiles() {
        return vaultService.getAllFiles();
    }
    
    // Request DTO for file uploads
    public static class FileUploadRequest {
        private String fileName;
        private String fileType;

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
    }
}
