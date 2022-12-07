package com.fashion.fashionblogapi.services;

import com.fashion.fashionblogapi.entities.Comments;
import com.fashion.fashionblogapi.entities.Posts;
import com.fashion.fashionblogapi.pojo.CommentsDto;
import com.fashion.fashionblogapi.repositories.CommentsRepository;
import com.fashion.fashionblogapi.repositories.PostsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService{

    private final CommentsRepository commentsRepository;
    private final PostsRepository postsRepository;

    Comments comments = new Comments();
    public CommentsServiceImpl(CommentsRepository commentsRepository, PostsRepository postsRepository) {
        this.commentsRepository = commentsRepository;
        this.postsRepository = postsRepository;
    }

    @Override
    public List<Comments> getAllComments(Long postsId) {
        Posts posts = new Posts();
        posts.setPostId(postsId);
        List<Comments> comments = commentsRepository.findCommentsByPosts(posts);
        return comments;
    }

    //id;
    //    private String comments;

    @Override
    public Comments createComment(CommentsDto commentsDto) {
        Posts posts = new Posts();
        posts.setPostId(commentsDto.getPostId());
        Comments comments = new Comments();
        comments.setComments(commentsDto.getComments());
        comments.setPosts(posts);

        return commentsRepository.save(comments);
    }

    @Override
    public Comments getComment(Long id) {
        Comments comments = commentsRepository.findCommentsByCommentId(id).get();
        return comments;
    }

    @Override
    public Comments updateComment(Long id, CommentsDto commentsDto) {
        if (commentsRepository.findCommentsByCommentId(id).isPresent()) {
            Comments existingComments = commentsRepository.findCommentsByCommentId(id).get();
            existingComments.setComments(commentsDto.getComments());
            commentsRepository.save(existingComments);
            return existingComments;
        }
        return null;
    }

    @Override
    public void deleteComment(Long id) {
        commentsRepository.deleteCommentsByCommentId(id);
    }
}
