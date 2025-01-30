package com.misfitpoets.agentmatch.domain;

import javax.persistence.*;

@Entity
@Table(name = "agent_profiles")
public class AgentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String agentName;
    private String email;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    private int yearsOfExperience;

    // Constructors, getters, setters
}
