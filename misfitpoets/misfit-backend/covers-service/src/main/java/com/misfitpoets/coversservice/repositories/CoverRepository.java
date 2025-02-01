// CoverRepository.java
// Location: misfitpoets/misfitpoets-backend/covers-service/src/main/java/com/misfitpoets/coversservice/repositories/CoverRepository.java
package com.misfitpoets.coversservice.repositories;

import com.misfitpoets.coversservice.models.Cover;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverRepository extends JpaRepository<Cover, Long> {
    // Additional custom query methods can be added here if needed
}
