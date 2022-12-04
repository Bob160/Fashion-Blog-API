package com.fashion.fashionblogapi.services;

import com.fashion.fashionblogapi.entities.Comments;
import com.fashion.fashionblogapi.entities.Likes;
import com.fashion.fashionblogapi.entities.Posts;
import com.fashion.fashionblogapi.entities.Users;
import com.fashion.fashionblogapi.pojo.LikesDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public interface LikesService {
    List<Likes> postLikes = new ArrayList<>();
    List<Likes> commentLikes = new ArrayList<>();
    List<Likes> getAllUserLikes (Long userId);
    boolean likePosts(Long postId, String action);
    boolean likesComments(Long commentId, String action);


    public void deletePostLikes(Long postId);
    public void deleteCommentLikes(Long commentId);

}
