// FileRecordRepository.java
// Location: misfitpoets/misfitpoets-backend/vault-service/src/main/java/com/misfitpoets/vaultservice/repositories/FileRecordRepository.java
package com.misfitpoets.vaultservice.repositories;

import com.misfitpoets.vaultservice.models.FileRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRecordRepository extends JpaRepository<FileRecord, Long> {
    // Additional query methods can be added here if needed
}
