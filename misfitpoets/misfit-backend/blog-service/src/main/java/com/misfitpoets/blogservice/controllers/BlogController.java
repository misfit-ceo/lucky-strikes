// BlogController.java
// Location: misfitpoets/misfitpoets-backend/blog-service/src/main/java/com/misfitpoets/blogservice/controllers/BlogController.java
package com.misfitpoets.blogservice.controllers;

import com.misfitpoets.blogservice.models.Post;
import com.misfitpoets.blogservice.services.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    /**
     * POST /api/blog/posts
     * Create a new blog post.
     *
     * @param post The Post object containing title, content, and author.
     * @return The created Post.
     */
    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        return blogService.createPost(post);
    }

    /**
     * GET /api/blog/posts
     * Retrieve all blog posts.
     *
     * @return A list of Post objects.
     */
    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return blogService.getAllPosts();
    }

    /**
     * GET /api/blog/posts/{id}
     * Retrieve a blog post by its ID.
     *
     * @param id The Post ID.
     * @return The Post object if found.
     */
    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable Long id) {
        return blogService.getPostById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id " + id));
    }

    /**
     * PUT /api/blog/posts/{id}
     * Update an existing blog post.
     *
     * @param id The Post ID.
     * @param post The Post object containing updated data.
     * @return The updated Post.
     */
    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        return blogService.updatePost(id, post);
    }

    /**
     * DELETE /api/blog/posts/{id}
     * Delete a blog post by its ID.
     *
     * @param id The Post ID.
     */
    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        blogService.deletePost(id);
    }
}
