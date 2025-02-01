// NodeRepository.java
// Location: misfitpoets/misfitpoets-backend/weave-service/src/main/java/com/misfitpoets/weaveservice/repositories/NodeRepository.java
package com.misfitpoets.weaveservice.repositories;

import com.misfitpoets.weaveservice.models.Node;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<Node, Long> {
    // Additional query methods can be defined here if needed
}
