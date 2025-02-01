// BlogService.java
// Location: misfitpoets/misfitpoets-backend/blog-service/src/main/java/com/misfitpoets/blogservice/services/BlogService.java
package com.misfitpoets.blogservice.services;

import com.misfitpoets.blogservice.models.Post;
import com.misfitpoets.blogservice.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    private final PostRepository postRepository;

    public BlogService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Create a new blog post
    public Post createPost(Post post) {
        post.setPublishedAt(LocalDateTime.now());
        return postRepository.save(post);
    }

    // Retrieve all blog posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Retrieve a blog post by its ID
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    // Update an existing blog post
    public Post updatePost(Long id, Post updatedPost) {
        return postRepository.findById(id)
                .map(post -> {
                    post.setTitle(updatedPost.getTitle());
                    post.setContent(updatedPost.getContent());
                    post.setAuthor(updatedPost.getAuthor());
                    // Optionally update publishedAt if desired
                    return postRepository.save(post);
                })
                .orElseThrow(() -> new RuntimeException("Post not found with id " + id));
    }

    // Delete a blog post by its ID
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
