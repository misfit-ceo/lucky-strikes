// Agent.java
// Location: misfitpoets/misfitpoets-backend/agent-match-service/src/main/java/com/misfitpoets/agentmatchservice/models/Agent.java
package com.misfitpoets.agentmatchservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Agent {
    @Id
    private String id;
    private String name;
    private String specialty;
    // Constructors, getters, and setters omitted for brevity
}
