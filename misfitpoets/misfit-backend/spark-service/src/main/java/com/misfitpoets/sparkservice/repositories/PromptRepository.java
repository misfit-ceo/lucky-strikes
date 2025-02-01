// PromptRepository.java
// Location: misfitpoets/misfitpoets-backend/spark-service/src/main/java/com/misfitpoets/sparkservice/repositories/PromptRepository.java
package com.misfitpoets.sparkservice.repositories;

import com.misfitpoets.sparkservice.models.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromptRepository extends JpaRepository<Prompt, Long> {
    // Additional custom query methods can be defined here if needed
}
