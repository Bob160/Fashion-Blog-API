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
//    public ResponseEntity<?> createPosts(@RequestBody PostsDto postsDto) {
//        Map<String, Object> map = new LinkedHashMap<String, Object>();
//        postsService.createPosts(postsDto);
//        map.put("status", 1);
//        map.put("message", "Post created successfully!");
//        map.put("post", postsDto);
//        return new ResponseEntity<>(map, HttpStatus.CREATED);
//    }
    public ResponseEntity<PostsDto> createPosts(@RequestBody PostsDto postsDto) {
     postsService.createPosts(postsDto);
     return new ResponseEntity<>(postsDto, HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postsId}")
    public ResponseEntity<Posts> getPosts(@PathVariable Long postsId) {
        Posts posts = postsService.getPosts(postsId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PutMapping("/update/{postsId}")
    public ResponseEntity<String> updatePosts(@PathVariable Long postsId, @RequestBody PostsDto postsDto ) {
        postsService.updatePosts(postsId, postsDto);
        return new ResponseEntity<>("Post updated successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{postsId}")
    public ResponseEntity<String> deletePosts(@PathVariable Long postsId) {
        postsService.deletePosts(postsId);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.NO_CONTENT);
    }

}
