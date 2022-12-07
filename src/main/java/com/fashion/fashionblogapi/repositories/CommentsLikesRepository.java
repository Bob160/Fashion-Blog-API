package com.fashion.fashionblogapi.repositories;

import com.fashion.fashionblogapi.entities.CommentsLikes;
import com.fashion.fashionblogapi.entities.PostsLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentsLikesRepository extends JpaRepository<CommentsLikes, Long> {
//    Optional<CommentsLikes> findByCommentLikesId(Long commentsId);
    //Optional<PostsLikes> findByUserIdAndPostId(Long userId, Long postId);
}
