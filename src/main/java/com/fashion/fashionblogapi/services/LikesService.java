package com.fashion.fashionblogapi.services;

import com.fashion.fashionblogapi.entities.Likes;
import com.fashion.fashionblogapi.pojo.LikesDto;

import java.util.ArrayList;
import java.util.List;

public interface LikesService {
    List<Likes> postLikes = new ArrayList<>();
    List<Likes> commentLikes = new ArrayList<>();

    public Likes addPostLikes(Long postId, LikesDto likesDto);
    public Likes addCommentLikes(Long commentId, LikesDto likesDto);
    List<Likes> getAllUserLikes (Long userId);

    public void deletePostLikes(Long id);
    public void deleteCommentLikes(Long id);

}
