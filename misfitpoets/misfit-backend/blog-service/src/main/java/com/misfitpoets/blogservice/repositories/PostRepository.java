// PostRepository.java
// Location: misfitpoets/misfitpoets-backend/blog-service/src/main/java/com/misfitpoets/blogservice/repositories/PostRepository.java
package com.misfitpoets.blogservice.repositories;

import com.misfitpoets.blogservice.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // Additional query methods (e.g., findByAuthor) can be added here if needed
}
