package com.fashion.fashionblogapi.services;

import com.fashion.fashionblogapi.entities.CommentsLikes;
import com.fashion.fashionblogapi.repositories.CommentsLikesRepository;
import com.fashion.fashionblogapi.repositories.CommentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsLikesServiceImpl implements CommentsLikesService {

    private final CommentsLikesRepository commentsLikesRepository;
    //private final PostsLikesRepository postsLikesRepository;
//    private final CommentsRepository commentsRepository;

    public CommentsLikesServiceImpl(CommentsLikesRepository commentsLikesRepository) {
        this.commentsLikesRepository = commentsLikesRepository;
//        this.commentsRepository = commentsRepository;
    }


    @Override
    public boolean likeComments(Long usersId, Long commentsId) {
        boolean result = false;

        CommentsLikes commentsLikes = commentsLikesRepository.findById(commentsId).orElse(null);
        if (commentsLikes == null) {
            CommentsLikes commentsLikes1 = new CommentsLikes();
            commentsLikes1.setUsersId(usersId);
            commentsLikes1.setCommentsId(commentsId);
            commentsLikesRepository.save(commentsLikes1);
            return true;
        } else {
            commentsLikesRepository.delete(commentsLikes);
        }

        return false;
    }


}
