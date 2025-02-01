// LinkRepository.java
// Location: misfitpoets/misfitpoets-backend/weave-service/src/main/java/com/misfitpoets/weaveservice/repositories/LinkRepository.java
package com.misfitpoets.weaveservice.repositories;

import com.misfitpoets.weaveservice.models.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Long> {
    Optional<Link> findBySourceIdAndTargetId(Long sourceId, Long targetId);
    void deleteBySourceIdAndTargetId(Long sourceId, Long targetId);
}
