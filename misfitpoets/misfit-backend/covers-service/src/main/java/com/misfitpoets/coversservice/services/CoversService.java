// CoverService.java
// Location: misfitpoets/misfitpoets-backend/covers-service/src/main/java/com/misfitpoets/coversservice/services/CoverService.java
package com.misfitpoets.coversservice.services;

import com.misfitpoets.coversservice.models.Cover;
import com.misfitpoets.coversservice.repositories.CoverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoverService {

    private final CoverRepository coverRepository;

    public CoverService(CoverRepository coverRepository) {
        this.coverRepository = coverRepository;
    }

    /**
     * Simulate generating an AI-powered cover design.
     * In a production system, this might call an external AI API.
     *
     * @param bookTitle The title of the book.
     * @param genre     The genre of the book.
     * @return The created Cover object with a generated design URL.
     */
    public Cover requestCover(String bookTitle, String genre) {
        // Simulated design URL (this would be generated dynamically)
        String designUrl = "https://cdn.misfitpoets.com/covers/" + bookTitle.replaceAll("\\s+", "_") + "_" + genre + ".png";
        Cover cover = new Cover(bookTitle, genre, designUrl);
        return coverRepository.save(cover);
    }

    /**
     * Retrieve all cover design tasks.
     *
     * @return List of Cover objects.
     */
    public List<Cover> getAllCovers() {
        return coverRepository.findAll();
    }

    /**
     * Retrieve a specific cover by its ID.
     *
     * @param id The cover ID.
     * @return An Optional containing the Cover if found.
     */
    public Optional<Cover> getCoverById(Long id) {
        return coverRepository.findById(id);
    }
}
