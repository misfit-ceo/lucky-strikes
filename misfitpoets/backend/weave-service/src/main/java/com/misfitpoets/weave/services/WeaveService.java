package com.misfitpoets.weave.services;

import com.misfitpoets.weave.domain.IdeaLink;
import com.misfitpoets.weave.domain.IdeaNode;
import com.misfitpoets.weave.domain.enums.NodeEmotion;
import com.misfitpoets.weave.dto.NodeRequest;
import com.misfitpoets.weave.dto.NodeResponse;
import com.misfitpoets.weave.exceptions.NodeNotFoundException;
import com.misfitpoets.weave.repositories.IdeaLinkRepository;
import com.misfitpoets.weave.repositories.IdeaNodeRepository;
import com.misfitpoets.weave.util.WeaveMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeaveService {

    private final IdeaNodeRepository nodeRepo;
    private final IdeaLinkRepository linkRepo;
    private final WeaveMapper mapper;

    public WeaveService(IdeaNodeRepository nodeRepo, IdeaLinkRepository linkRepo, WeaveMapper mapper) {
        this.nodeRepo = nodeRepo;
        this.linkRepo = linkRepo;
        this.mapper = mapper;
    }

    public NodeResponse createNode(NodeRequest req) {
        IdeaNode node = mapper.toEntity(req);
        node = nodeRepo.save(node);
        return mapper.toResponse(node);
    }

    public List<NodeResponse> listNodes() {
        return nodeRepo.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public NodeResponse getNode(Long id) {
        IdeaNode found = nodeRepo.findById(id)
                .orElseThrow(() -> new NodeNotFoundException("Node not found: " + id));
        return mapper.toResponse(found);
    }

    public NodeResponse updateNode(Long id, NodeRequest req) {
        IdeaNode found = nodeRepo.findById(id)
                .orElseThrow(() -> new NodeNotFoundException("Cannot update. Node " + id + " not found."));

        found.setLabel(req.getLabel());
        found.setDescription(req.getDescription());
        found.setOwnerId(req.getOwnerId());
        try {
            found.setEmotion(NodeEmotion.valueOf(req.getEmotion().toUpperCase()));
        } catch (Exception e) {
            found.setEmotion(NodeEmotion.CURIOUS); // fallback
        }

        found = nodeRepo.save(found);
        return mapper.toResponse(found);
    }

    public void deleteNode(Long id) {
        IdeaNode found = nodeRepo.findById(id)
                .orElseThrow(() -> new NodeNotFoundException("Cannot delete. Node " + id + " not found."));
        // If orphanRemoval = true, IdeaLink should cascade
        nodeRepo.delete(found);
    }

    public void linkNodes(Long sourceId, Long targetId) {
        IdeaNode source = nodeRepo.findById(sourceId)
                .orElseThrow(() -> new NodeNotFoundException("Source node not found: " + sourceId));
        IdeaNode target = nodeRepo.findById(targetId)
                .orElseThrow(() -> new NodeNotFoundException("Target node not found: " + targetId));

        IdeaLink link = new IdeaLink();
        link.setSourceNode(source);
        link.setTargetNode(target);

        linkRepo.save(link);
    }

    public void unlinkNodes(Long sourceId, Long targetId) {
        // Find the link(s) that match
        List<IdeaLink> links = linkRepo.findAll().stream()
                .filter(l -> l.getSourceNode().getId().equals(sourceId)
                          && l.getTargetNode().getId().equals(targetId))
                .collect(Collectors.toList());

        linkRepo.deleteAll(links);
    }
}
