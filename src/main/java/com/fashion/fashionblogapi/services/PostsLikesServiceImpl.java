package com.fashion.fashionblogapi.services;

import com.fashion.fashionblogapi.entities.PostsLikes;
import com.fashion.fashionblogapi.repositories.PostsLikesRepository;
import com.fashion.fashionblogapi.repositories.PostsRepository;
import org.springframework.stereotype.Service;

@Service
public class PostsLikesServiceImpl implements PostsLikesService{


    private final PostsLikesRepository postsLikesRepository;
//    private final PostsRepository postsRepository;

    public PostsLikesServiceImpl(PostsLikesRepository postsLikesRepository) {
        this.postsLikesRepository = postsLikesRepository;
//        this.postsRepository = postsRepository;
    }

    @Override
    public boolean likePosts(Long usersId, Long postsId) {
        boolean result = false;

        PostsLikes postsLikes = postsLikesRepository.findByUserIdAndPostId(usersId, postsId).orElse(null);
        if (postsLikes == null) {
            PostsLikes postsLikes1 = new PostsLikes();
            postsLikes1.setUserId(usersId);
            postsLikes1.setPostId(postsId);
            postsLikesRepository.save(postsLikes1);
            return true;
        } else {
            postsLikesRepository.delete(postsLikes);
        }
        return false;
    }

//    @Override
//    public void deletePostLikes(Long postsId) {
//
//    }
}
