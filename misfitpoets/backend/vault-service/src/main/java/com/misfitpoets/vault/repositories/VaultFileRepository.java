package com.misfitpoets.vault.repositories;

import com.misfitpoets.vault.domain.VaultFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaultFileRepository extends JpaRepository<VaultFile, Long> {
    List<VaultFile> findByOwnerId(String ownerId);
}
