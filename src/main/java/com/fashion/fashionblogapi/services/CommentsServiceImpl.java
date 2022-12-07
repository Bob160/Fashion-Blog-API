package com.fashion.fashionblogapi.services;

import com.fashion.fashionblogapi.entities.Comments;
import com.fashion.fashionblogapi.entities.Posts;
import com.fashion.fashionblogapi.pojo.CommentsDto;
import com.fashion.fashionblogapi.repositories.CommentsRepository;
import com.fashion.fashionblogapi.repositories.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;

    @Override
    public List<Comments> getAllComments(Long postsId) {
        Posts posts = new Posts();
        posts.setPostId(postsId);
        return commentsRepository.findAllByPosts(posts);
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
        return commentsRepository.findById(id).orElse(null);
    }

    @Override
    public Comments updateComment(Long id, CommentsDto commentsDto) {
        Comments existingComments = commentsRepository.findById(id).orElse(null);
        if (existingComments != null) {
            existingComments.setComments(commentsDto.getComments());
            commentsRepository.save(existingComments);
            return existingComments;
        }
        return null;
    }

    @Override
    public void deleteComment(Long id) {
        commentsRepository.deleteById(id);
    }
}
