package com.misfitpoets.scribe.services;

import com.misfitpoets.scribe.domain.Document;
import com.misfitpoets.scribe.repositories.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScribeService {

    private final DocumentRepository documentRepository;

    public ScribeService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document createDocument(Document doc) {
        return documentRepository.save(doc);
    }

    public Document getDocument(Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    public List<Document> listDocuments() {
        return documentRepository.findAll();
    }
}
