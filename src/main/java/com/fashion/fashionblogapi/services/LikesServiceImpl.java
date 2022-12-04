package com.fashion.fashionblogapi.services;

import com.fashion.fashionblogapi.entities.Comments;
import com.fashion.fashionblogapi.entities.Likes;
import com.fashion.fashionblogapi.entities.Posts;
import com.fashion.fashionblogapi.entities.Users;
import com.fashion.fashionblogapi.pojo.LikesDto;
import com.fashion.fashionblogapi.repositories.CommentsRepository;
import com.fashion.fashionblogapi.repositories.LikesRepository;
import com.fashion.fashionblogapi.repositories.PostsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesServiceImpl implements LikesService{

    private final LikesRepository likesRepository;
    private final CommentsRepository commentsRepository;
    private final PostsRepository postsRepository;

    Likes likes = new Likes();
    public LikesServiceImpl(LikesRepository likesRepository, CommentsRepository commentsRepository, PostsRepository postsRepository) {
        this.likesRepository = likesRepository;
        this.commentsRepository = commentsRepository;
        this.postsRepository = postsRepository;
    }


    @Override
    public List<Likes> getAllUserLikes(Long userId) {
        return null;
    }

    @Override
    public boolean likePosts(Long postId, String action) {
        boolean result = false;
        Posts posts = postsRepository.findPostsById(postId);
        Likes likes = new Likes();
        likes.setPosts(posts);
        if (action.equals("1")) {
            likesRepository.save(likes);
            System.out.println("Saved");
        } else {
            System.out.println("Deleted");
        }
        return false;
    }

    @Override
    public boolean likesComments(Long commentId, String action) {
        boolean result = false;
        Comments comments = commentsRepository.findCommentsByPostsId(commentId);
        Likes likes = new Likes();
        likes.setComments(comments);
        if (action.equals("1")) {
            likesRepository.save(likes);
            System.out.println("Saved");
        } else {
            System.out.println("Deleted");
        }
        return false;
    }

    @Override
    public void deletePostLikes(Long postId) {
        likesRepository.deleteLikesByPostsId(postId);
    }

    @Override
    public void deleteCommentLikes(Long commentId) {
        likesRepository.deleteLikesByCommentsId(commentId);
    }
}
