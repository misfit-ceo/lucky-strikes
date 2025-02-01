// CoversController.java
// Location: misfitpoets/misfitpoets-backend/covers-service/src/main/java/com/misfitpoets/coversservice/controllers/CoversController.java
package com.misfitpoets.coversservice.controllers;

import com.misfitpoets.coversservice.models.Cover;
import com.misfitpoets.coversservice.services.CoverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/covers")
public class CoversController {

    private final CoverService coverService;

    public CoversController(CoverService coverService) {
        this.coverService = coverService;
    }

    /**
     * POST /api/covers/request
     * Create a new cover design request.
     *
     * @param request A JSON object containing "bookTitle" and "genre".
     * @return The generated Cover object.
     */
    @PostMapping("/request")
    public Cover requestCover(@RequestBody CoverRequest request) {
        return coverService.requestCover(request.getBookTitle(), request.getGenre());
    }

    /**
     * GET /api/covers
     * Retrieve all cover design tasks.
     *
     * @return List of Cover objects.
     */
    @GetMapping
    public List<Cover> getAllCovers() {
        return coverService.getAllCovers();
    }

    /**
     * GET /api/covers/{id}
     * Retrieve a specific cover by its ID.
     *
     * @param id The cover ID.
     * @return The Cover object if found.
     */
    @GetMapping("/{id}")
    public Cover getCoverById(@PathVariable Long id) {
        return coverService.getCoverById(id)
                .orElseThrow(() -> new RuntimeException("Cover not found with id " + id));
    }
    
    // Request DTO for cover requests
    public static class CoverRequest {
        private String bookTitle;
        private String genre;

        public String getBookTitle() {
            return bookTitle;
        }

        public void setBookTitle(String bookTitle) {
            this.bookTitle = bookTitle;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }
    }
}
