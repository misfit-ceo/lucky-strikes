package com.misfitpoets.vault.util;

import com.misfitpoets.vault.domain.VaultFile;
import com.misfitpoets.vault.dto.FileResponse;
import org.springframework.stereotype.Component;

@Component
public class VaultMapper {

    public FileResponse toResponse(VaultFile entity) {
        FileResponse resp = new FileResponse();
        resp.setId(entity.getId());
        resp.setFileName(entity.getFileName());
        resp.setContentType(entity.getContentType());
        resp.setOwnerId(entity.getOwnerId());
        resp.setStoredFormat(entity.getStoredFormat());
        return resp;
    }
}