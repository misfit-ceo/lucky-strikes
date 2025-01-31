package com.misfitpoets.spark.repositories;

import com.misfitpoets.spark.domain.SparkPrompt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SparkPromptRepository extends JpaRepository<SparkPrompt, Long> {
    // Additional queries if needed
}
