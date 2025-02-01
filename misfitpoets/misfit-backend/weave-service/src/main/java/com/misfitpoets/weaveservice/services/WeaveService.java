// WeaveController.java
// Location: misfitpoets/misfitpoets-backend/weave-service/src/main/java/com/misfitpoets/weaveservice/controllers/WeaveController.java
package com.misfitpoets.weaveservice.controllers;

import com.misfitpoets.weaveservice.models.Node;
import com.misfitpoets.weaveservice.models.Link;
import com.misfitpoets.weaveservice.services.WeaveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weave")
public class WeaveController {

    private final WeaveService weaveService;

    public WeaveController(WeaveService weaveService) {
        this.weaveService = weaveService;
    }

    /**
     * POST /api/weave/nodes
     * Create a new idea node.
     *
     * @param node The node object to create.
     * @return The created node.
     */
    @PostMapping("/nodes")
    public Node createNode(@RequestBody Node node) {
        return weaveService.createNode(node);
    }

    /**
     * GET /api/weave/nodes
     * Retrieve all idea nodes.
     *
     * @return A list of nodes.
     */
    @GetMapping("/nodes")
    public List<Node> getAllNodes() {
        return weaveService.getAllNodes();
    }

    /**
     * GET /api/weave/nodes/{id}
     * Retrieve a specific node by its ID.
     *
     * @param id The node ID.
     * @return The node object.
     */
    @GetMapping("/nodes/{id}")
    public Node getNodeById(@PathVariable Long id) {
        return weaveService.getNodeById(id)
                .orElseThrow(() -> new RuntimeException("Node not found with id " + id));
    }

    /**
     * POST /api/weave/links/{sourceId}/{targetId}
     * Create a link between two nodes.
     *
     * @param sourceId The ID of the source node.
     * @param targetId The ID of the target node.
     * @return The created link.
     */
    @PostMapping("/links/{sourceId}/{targetId}")
    public Link createLink(@PathVariable Long sourceId, @PathVariable Long targetId) {
        return weaveService.createLink(sourceId, targetId);
    }

    /**
     * DELETE /api/weave/links/{sourceId}/{targetId}
     * Remove the link between two nodes.
     *
     * @param sourceId The ID of the source node.
     * @param targetId The ID of the target node.
     */
    @DeleteMapping("/links/{sourceId}/{targetId}")
    public void deleteLink(@PathVariable Long sourceId, @PathVariable Long targetId) {
        weaveService.deleteLink(sourceId, targetId);
    }
}
