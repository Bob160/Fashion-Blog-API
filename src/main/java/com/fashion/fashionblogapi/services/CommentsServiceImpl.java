package com.fashion.fashionblogapi.services;

import com.fashion.fashionblogapi.entities.Comments;
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
        List<Comments> comments = commentsRepository.findCommentsByPostsId(postsId);
        return comments;
    }

    //id;
    //    private String comments;

    @Override
    public Comments createComment(CommentsDto commentsDto) {
        Comments comments = new Comments();
        comments.setComment(commentsDto.getComments());
        commentsRepository.save(comments);
        return comments;
    }

    @Override
    public Comments getComment(Long id) {
        Comments comments = commentsRepository.findCommentsById(id).get();
        return comments;
    }

    @Override
    public Comments updateComment(Long id, CommentsDto commentsDto) {
        if (commentsRepository.findCommentsById(id).isPresent()) {
            Comments existingComments = commentsRepository.findCommentsById(id).get();
            existingComments.setComment(commentsDto.getComments());
            commentsRepository.save(existingComments);
            return existingComments;
        }
        return null;
    }

    @Override
    public void deleteComment(Long id) {
        commentsRepository.deleteCommentsById(id);
    }
}
