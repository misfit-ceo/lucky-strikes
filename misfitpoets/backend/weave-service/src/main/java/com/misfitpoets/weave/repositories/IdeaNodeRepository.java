package com.misfitpoets.weave.repositories;

import com.misfitpoets.weave.domain.IdeaNode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdeaNodeRepository extends JpaRepository<IdeaNode, Long> {
    // Additional queries if needed
}
