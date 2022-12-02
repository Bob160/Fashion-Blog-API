package com.fashion.fashionblogapi.services;

import com.fashion.fashionblogapi.entities.Comments;
import com.fashion.fashionblogapi.pojo.CommentsDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface CommentsService {
    //Create List to hold all comments
    List<Comments> comments = new ArrayList<>();
    List<Comments> getAllComments(Long postsId);

    public Comments getComment(Long id);
    public Comments createComment(CommentsDto commentsDto);
    public Comments updateComment(Long id, CommentsDto commentsDto);
    public  void deleteComment (Long id);

}
