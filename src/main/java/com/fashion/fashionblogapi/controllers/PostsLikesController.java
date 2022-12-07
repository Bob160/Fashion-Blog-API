package com.fashion.fashionblogapi.controllers;

import com.fashion.fashionblogapi.services.PostsLikesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class PostsLikesController {

    private final PostsLikesService postsLikesService;

    @PostMapping("/like/{postsId}")
    public ResponseEntity<String> likePosts (Long userId, @PathVariable Long postsId) {
        postsLikesService.likePosts(userId, postsId);
        return new ResponseEntity<>("Post liked successfully", HttpStatus.OK);
    }
}
