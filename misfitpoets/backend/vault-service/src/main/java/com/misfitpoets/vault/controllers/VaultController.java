package com.misfitpoets.vault.controllers;

import com.misfitpoets.vault.dto.FileRequest;
import com.misfitpoets.vault.dto.FileResponse;
import com.misfitpoets.vault.services.VaultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/vault")
public class VaultController {

    private final VaultService vaultService;

    public VaultController(VaultService vaultService) {
        this.vaultService = vaultService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "vault-service is up!";
    }

    // 1) Upload a file
    @PostMapping("/upload")
    public ResponseEntity<FileResponse> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("ownerId") String ownerId
    ) {
        FileResponse saved = vaultService.uploadFile(file, ownerId);
        return ResponseEntity.ok(saved);
    }

    // 2) List files for a user
    @GetMapping("/files")
    public ResponseEntity<List<FileResponse>> listFiles(@RequestParam("ownerId") String ownerId) {
        return ResponseEntity.ok(vaultService.listFiles(ownerId));
    }

    // 3) Download file
    @GetMapping("/files/{id}/download")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        return vaultService.downloadFile(id);
    }

    // 4) Convert a file (optional query param to target format, e.g. "PDF", "DOCX")
    @PostMapping("/files/{id}/convert")
    public ResponseEntity<FileResponse> convertFile(
            @PathVariable Long id,
            @RequestParam("targetFormat") String targetFormat
    ) {
        return ResponseEntity.ok(vaultService.convertFile(id, targetFormat));
    }

    // 5) Delete file
    @DeleteMapping("/files/{id}")
    public ResponseEntity<Void> deleteFile(@PathVariable Long id) {
        vaultService.deleteFile(id);
        return ResponseEntity.noContent().build();
    }
}
