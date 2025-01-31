package com.misfitpoets.weave.repositories;

import com.misfitpoets.weave.domain.IdeaLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdeaLinkRepository extends JpaRepository<IdeaLink, Long> {
    // Additional queries if needed
}
