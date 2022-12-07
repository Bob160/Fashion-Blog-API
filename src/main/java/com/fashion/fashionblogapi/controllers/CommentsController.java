package com.fashion.fashionblogapi.controllers;

import com.fashion.fashionblogapi.entities.Comments;
import com.fashion.fashionblogapi.pojo.CommentsDto;
import com.fashion.fashionblogapi.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class CommentsController {

    private final CommentsService commentsService;

    @Autowired
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping("/comment/{commentsId}")
    public ResponseEntity<Comments> getComments(@PathVariable Long commentsId) {
        Comments comments = commentsService.getComment(commentsId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("/comment")
    public ResponseEntity<Comments> createComments(@RequestBody CommentsDto commentsDto) {
        Comments comments = commentsService.createComment(commentsDto);
        return new ResponseEntity<>(comments, HttpStatus.CREATED);
    }

    @PutMapping("/comment/update-comment/{commentsId}")
    public ResponseEntity<String> updateComments(@PathVariable Long commentsId, @RequestBody CommentsDto commentsDto) {
        commentsService.updateComment(commentsId, commentsDto);
        return new ResponseEntity<>("Comment updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/comment/delete/{commentsId}")
    public ResponseEntity<String> deleteComments(@PathVariable Long commentsId) {
        commentsService.deleteComment(commentsId);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.NO_CONTENT);
    }
}
