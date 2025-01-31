package com.misfitpoets.weave.dto;

import java.util.List;

public class NodeResponse {
    private Long id;
    private String label;
    private String description;
    private String emotion;
    private String ownerId;
    private List<Long> linkedNodeIds;   // If you want to show which IDs are linked

    // getters, setters
}
