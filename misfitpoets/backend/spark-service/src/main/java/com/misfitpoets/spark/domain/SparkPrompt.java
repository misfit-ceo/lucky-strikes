package com.misfitpoets.spark.domain;

import com.misfitpoets.spark.domain.enums.PromptTone;

import javax.persistence.*;

@Entity
@Table(name = "spark_prompts")
public class SparkPrompt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String theme;        // e.g., "healing", "fantasy", "sci-fi"
    private String style;        // e.g., "sonnet", "haiku", "dramatic"
    private String promptText;   // The generated prompt text

    @Enumerated(EnumType.STRING)
    private PromptTone tone;     // e.g., UPLIFTING, MYSTERIOUS

    // Optionally store user info or usage stats
    private String ownerId;

    // Constructors, getters, setters
}
