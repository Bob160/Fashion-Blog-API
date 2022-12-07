package com.fashion.fashionblogapi.controllers;

import com.fashion.fashionblogapi.services.CommentsLikesService;
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
public class CommentsLikesController {

    private final CommentsLikesService commentsLikesService;

    @PostMapping("/like/{commentsId}")
    public ResponseEntity<String> likeComments (Long userId, @PathVariable Long commentsId) {
        commentsLikesService.likeComments(userId, commentsId);
        return new ResponseEntity<>("Comment liked successfully!", HttpStatus.OK);
    }
}
