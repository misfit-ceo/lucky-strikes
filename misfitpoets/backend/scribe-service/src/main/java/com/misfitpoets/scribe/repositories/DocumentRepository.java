package com.misfitpoets.scribe.repositories;

import com.misfitpoets.scribe.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
