package com.misfitpoets.weave.domain;

import com.misfitpoets.weave.domain.enums.NodeEmotion;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "idea_nodes")
public class IdeaNode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;         // e.g., "Character Trait" or "Poem Concept"
    private String description;   // optional text

    @Enumerated(EnumType.STRING)
    private NodeEmotion emotion;  // e.g., JOYFUL, SOMBER

    // Example linking approach:
    @OneToMany(mappedBy = "sourceNode", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IdeaLink> outboundLinks = new HashSet<>();

    // For searching or organizing
    private String ownerId;

    // Constructors, getters, setters
}
