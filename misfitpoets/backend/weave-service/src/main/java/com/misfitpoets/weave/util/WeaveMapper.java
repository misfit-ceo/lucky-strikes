package com.misfitpoets.weave.util;

import com.misfitpoets.weave.domain.IdeaLink;
import com.misfitpoets.weave.domain.IdeaNode;
import com.misfitpoets.weave.domain.enums.NodeEmotion;
import com.misfitpoets.weave.dto.NodeRequest;
import com.misfitpoets.weave.dto.NodeResponse;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class WeaveMapper {

    public IdeaNode toEntity(NodeRequest req) {
        IdeaNode node = new IdeaNode();
        node.setLabel(req.getLabel());
        node.setDescription(req.getDescription());
        node.setOwnerId(req.getOwnerId());
        try {
            node.setEmotion(NodeEmotion.valueOf(req.getEmotion().toUpperCase()));
        } catch (Exception e) {
            node.setEmotion(NodeEmotion.CURIOUS);
        }
        return node;
    }

    public NodeResponse toResponse(IdeaNode node) {
        NodeResponse resp = new NodeResponse();
        resp.setId(node.getId());
        resp.setLabel(node.getLabel());
        resp.setDescription(node.getDescription());
        resp.setEmotion(node.getEmotion() != null ? node.getEmotion().name() : null);
        resp.setOwnerId(node.getOwnerId());

        // Convert each IdeaLink (target) to just the target ID:
        resp.setLinkedNodeIds(node.getOutboundLinks().stream()
                .map(link -> link.getTargetNode().getId())
                .collect(Collectors.toList()));

        return resp;
    }
}
