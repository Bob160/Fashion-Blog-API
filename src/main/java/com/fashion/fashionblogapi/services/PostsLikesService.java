package com.fashion.fashionblogapi.services;

import com.fashion.fashionblogapi.entities.PostsLikes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface PostsLikesService {

    List<PostsLikes> postsLikes = new ArrayList<>();
    //List<PostsLikes> COMMENT_LIKES = new ArrayList<>();
    //List<PostsLikes> getAllUserLikes (Long userId);
    boolean likePosts(Long usersId, Long postsId);
    //boolean likeComments(Long userId, Long commentId);


    //public void deletePostLikes(Long postsId);
    //public void deleteCommentLikes(Long commentId);
}
