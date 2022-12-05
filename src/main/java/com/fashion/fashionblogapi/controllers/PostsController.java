package com.fashion.fashionblogapi.controllers;

import com.fashion.fashionblogapi.entities.Posts;
import com.fashion.fashionblogapi.pojo.PostsDto;
import com.fashion.fashionblogapi.services.PostsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class PostsController {

    private final PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    PostsDto postsDto;

    @PostMapping("/create-post")
    public ResponseEntity<PostsDto> createPosts(@RequestBody PostsDto postsDto) {
     postsService.createPosts(postsDto);
     return new ResponseEntity<>(postsDto, HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<Posts> getPosts(@PathVariable Long postId) {
        Posts posts = postsService.getPosts(postId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PutMapping("/update/{postId}")
    public ResponseEntity<String> updatePosts(@PathVariable Long postId, @RequestBody PostsDto postsDto ) {
        postsService.updatePosts(postId, postsDto);
        return new ResponseEntity<>("Post updated successfully!", HttpStatus.OK);
    }

    public ResponseEntity<String> deletePosts(@PathVariable Long postsId) {
        postsService.deletePosts(postsId);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.NO_CONTENT);
    }

}
