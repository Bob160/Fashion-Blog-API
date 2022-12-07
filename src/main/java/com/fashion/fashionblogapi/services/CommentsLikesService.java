package com.fashion.fashionblogapi.services;

import com.fashion.fashionblogapi.entities.PostsLikes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public interface CommentsLikesService {
    //List<PostsLikes> POSTS_LIKES = new ArrayList<>();
    List<PostsLikes> commentsLikes = new ArrayList<>();
    //List<PostsLikes> getAllUserLikes (Long usersId);
    //boolean likePosts(Long usersId, Long postId);

    //Make void and delete return statement
    boolean likeComments(Long usersId, Long commentsId);


    //public void deletePostLikes(Long postId);
    //public void deleteCommentsLikes(Long commentsId);

}
