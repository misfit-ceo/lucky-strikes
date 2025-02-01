package com.misfitpoets.vault.services;

import com.misfitpoets.vault.domain.VaultFile;
import com.misfitpoets.vault.dto.FileResponse;
import com.misfitpoets.vault.exceptions.VaultFileNotFoundException;
import com.misfitpoets.vault.repositories.VaultFileRepository;
import com.misfitpoets.vault.util.VaultMapper;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VaultService {

    private final VaultFileRepository fileRepo;
    private final VaultMapper mapper;

    public VaultService(VaultFileRepository fileRepo, VaultMapper mapper) {
        this.fileRepo = fileRepo;
        this.mapper = mapper;
    }

    public FileResponse uploadFile(MultipartFile file, String ownerId) {
        try {
            VaultFile vf = new VaultFile();
            vf.setFileName(file.getOriginalFilename());
            vf.setContentType(file.getContentType());
            vf.setOwnerId(ownerId);
            vf.setData(file.getBytes());
            // Infer format from contentType or extension:
            vf.setStoredFormat(guessFormat(file.getOriginalFilename()));

            vf = fileRepo.save(vf);
            return mapper.toResponse(vf);
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload file: " + e.getMessage());
        }
    }

    public List<FileResponse> listFiles(String ownerId) {
        return fileRepo.findByOwnerId(ownerId).stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public ResponseEntity<byte[]> downloadFile(Long id) {
        VaultFile vf = fileRepo.findById(id)
                .orElseThrow(() -> new VaultFileNotFoundException("File not found: " + id));

        // Prepare the response with file bytes
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(vf.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + vf.getFileName() + "\"")
                .body(vf.getData());
    }

    public FileResponse convertFile(Long id, String targetFormat) {
        // For demonstration, we won't do real conversions here, just simulate changing the format
        VaultFile vf = fileRepo.findById(id)
                .orElseThrow(() -> new VaultFileNotFoundException("File not found for conversion: " + id));

        // pretend to do some conversion
        vf.setStoredFormat(targetFormat.toUpperCase());
        // If you were converting PDF->DOCX or etc., you'd do it here

        vf = fileRepo.save(vf);
        return mapper.toResponse(vf);
    }

    public void deleteFile(Long id) {
        VaultFile vf = fileRepo.findById(id)
                .orElseThrow(() -> new VaultFileNotFoundException("Cannot delete. File not found: " + id));
        fileRepo.delete(vf);
    }

    private String guessFormat(String originalFilename) {
        if (originalFilename == null) {
            return "UNKNOWN";
        }
        // If ends with .pdf => PDF, if ends with .docx => DOCX, etc.
        String lower = originalFilename.toLowerCase();
        if (lower.endsWith(".pdf")) return "PDF";
        if (lower.endsWith(".docx")) return "DOCX";
        if (lower.endsWith(".png")) return "PNG";
        if (lower.endsWith(".jpg") || lower.endsWith(".jpeg")) return "JPG";
        return "UNKNOWN";
    }
}
